package com.zz.back.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zz.back.dao.ArticleDao;
import com.zz.back.dao.TagArticleDao;
import com.zz.back.dao.TagDao;
import com.zz.back.model.ArticleEntity;
import com.zz.back.model.TagArticleEntity;
import com.zz.back.model.TagEntity;
import com.zz.back.model.vo.ArticleListVo;
import com.zz.back.model.vo.ArticleVo;
import com.zz.back.model.vo.BaseVo;
import com.zz.back.service.IArticleService;
import com.zz.back.util.RandomCodeGenerator;
import com.zz.back.util.TurtleConstants;
import com.zz.back.util.cache.TurtleCache;
import com.zz.back.util.markrazi.Markrazi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

    @Resource
    private ArticleDao articleDao;

    @Resource
    private TagArticleDao tagArticleDao;

    @Resource
    private TagDao tagDao;

    private static Markrazi markrazi = new Markrazi();

    public ArticleVo getById(Long id, String format) {
        ArticleEntity article = articleDao.findOne(id);
        if (article == null) {
            throw new RuntimeException("对应的文章不存在 ID=" + id);
        }
        if (TurtleConstants.FORMAT_HTML.equals(format)) {
            article.setContent(markrazi.doMarkrazi(article.getContent()));
        }
        ArticleVo articleVo = new ArticleVo(article);
        articleVo.setCode(TurtleConstants.RESULT_SUCCESS);
        return new ArticleVo(article);
    }

    public List<ArticleEntity> findByTitle(String title) {
        return articleDao.findByTitle(title);
    }

    public ArticleListVo findByTag(String tag) {

        ArticleListVo vo = new ArticleListVo();
//        vo.setCode(TurtleConstants.RESULT_SUCCESS);
//        if (!TurtleCache.tagMap.containsKey(tag)) {
//            vo.setArticles(new ArrayList<>());
//            return vo;
//        }
//
//        Long id = TurtleCache.tagMap.get(tag);
//        List<ArticleEntity> articleList = tagArticleDao.findByTagId(id);
//        List<ArticleVo> voList = new ArrayList<>();
//        for (ArticleEntity article : articleList) {
//            voList.add(new ArticleVo(article));
//        }
//
//        vo.setArticles(voList);
        return vo;
    }

    /**
     * 获取所有文章，不包括临时文章
     * @return 文章列表
     */
    public ArticleListVo getAll() {
        List<ArticleEntity> articleList = articleDao.findByTitleNotNullOrderByIdDesc();
        List<ArticleVo> voList = new ArrayList<>();
        for (ArticleEntity article : articleList) {
            voList.add(new ArticleVo(article));
        }

        ArticleListVo vo = new ArticleListVo();
        vo.setArticles(voList);
        vo.setCode(TurtleConstants.RESULT_SUCCESS);
        return vo;
    }

    public ArticleListVo getPage(int page, int count) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, count, sort);
        Page<ArticleEntity> articlePage = articleDao.findAll(pageable);
        List<ArticleVo> voList = new ArrayList<>();
        for (ArticleEntity article : articlePage) {
            voList.add(new ArticleVo(article));
        }

        ArticleListVo vo = new ArticleListVo();
        vo.setArticles(voList);
        vo.setCode(TurtleConstants.RESULT_SUCCESS);
        return vo;
    }

    public BaseVo save(JSONObject articleJson) {
        //verify
        String validateCode = articleJson.getString("verifyCode");
        if(!RandomCodeGenerator.matchValidateCode(validateCode)) {
            throw new RuntimeException("认证码无效");
        }
        
        String title = articleJson.getString("title");
        String content = articleJson.getString("content");
        String summary = articleJson.getString("summary");
        String tags = articleJson.getString("tags");
        String creator = articleJson.getString("creator");
        String id = articleJson.getString("id");

        if (StringUtils.isBlank(creator)) {
            creator = TurtleConstants.DEFAULT_USER;
        }

        ArticleEntity article = new ArticleEntity();
        if (StringUtils.isNotBlank(id)) {
            article.setId(Long.valueOf(id));
        }

        article.setTitle(title);
        article.setContent(content);
        article.setSummary(summary);
        article.setTemp(TurtleConstants.TEMP_FALSE);

        Date curDate = new Date();
        article.setCreateTime(curDate);
        article.setUpdateTime(curDate);
        article.setCreator(creator);
        article = articleDao.save(article);

        //resolve tags
        if (StringUtils.isNotBlank(tags)) {
            String[] tagArray = tags.split(",");
            for (String tag : tagArray) {
                List<TagEntity> tagEntityList = tagDao.findByName(tag);
                Long tagId = 0L;
                if (tagEntityList.size() == 0) {
                    TagEntity saveTagEntity = new TagEntity();
                    saveTagEntity.setName(tag);
                    saveTagEntity = tagDao.save(saveTagEntity);
                    tagId = saveTagEntity.getId();
                } else {
                    tagId = tagEntityList.get(0).getId();
                }
                TagArticleEntity saveTagArticleEntity = new TagArticleEntity();
                saveTagArticleEntity.setArticle(article);
                saveTagArticleEntity.setTagId(tagId);
                tagArticleDao.save(saveTagArticleEntity);
            }
        }

        return new BaseVo(TurtleConstants.RESULT_SUCCESS, "新建文章成功 ID=" + article.getId());
    }

    public void delete(Long id) {
        articleDao.delete(id);
    }

}
