package com.zz.back.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zz.back.dao.ArticleDao;
import com.zz.back.dao.TagArticleDao;
import com.zz.back.dao.TagDao;
import com.zz.back.model.ArticleEntity;
import com.zz.back.model.TagArticleEntity;
import com.zz.back.model.TagEntity;
import com.zz.back.model.exception.EmptyParamException;
import com.zz.back.model.exception.NotFoundException;
import com.zz.back.model.request.ArticleSaveRequest;
import com.zz.back.model.vo.ArticleListVo;
import com.zz.back.model.vo.ArticleVo;
import com.zz.back.model.vo.BaseVo;
import com.zz.back.service.IArticleService;
import com.zz.back.util.BeanUtil;
import com.zz.back.util.RandomCodeGenerator;
import com.zz.back.util.TurtleConstants;
import com.zz.back.util.cache.TurtleCache;
import com.zz.back.util.markrazi.Markrazi;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
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

@Slf4j
@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

    @Resource
    private ArticleDao articleDao;

    @Resource
    private TagArticleDao tagArticleDao;

    @Resource
    private TagDao tagDao;

    @Resource
    private TurtleCache turtleCache;

    private static Markrazi markrazi = new Markrazi();

    public ArticleVo getById(Long id, String format) {
        ArticleEntity article = articleDao.findOne(id);
        if (article == null) {
            throw new NotFoundException("对应的文章不存在 ID=" + id);
        }
        ArticleVo articleVo = BeanUtil.toArticle(article);
        if (TurtleConstants.FORMAT_HTML.equals(format)) {
            articleVo.setContent(markrazi.doMarkrazi(article.getContent()));
        }
        return articleVo;
    }

    public List<ArticleEntity> findByTitle(String title) {
        return articleDao.findByTitle(title);
    }

    public ArticleListVo findByTag(String tag) {

        ArticleListVo vo = new ArticleListVo();
        if (!TurtleCache.tagMap.containsKey(tag)) {
            vo.setArticles(new ArrayList<>());
            return vo;
        }

        Long id = TurtleCache.tagMap.get(tag);
        List<TagArticleEntity> articleList = tagArticleDao.findByTagId(id);
        List<ArticleVo> voList = new ArrayList<>();
        for (TagArticleEntity tagArticleEntity : articleList) {
            ArticleEntity articleEntity = tagArticleEntity.getArticle();
            if (articleEntity != null) {
                voList.add(BeanUtil.toArticle(articleEntity));
            }
        }
        vo.setArticles(voList);
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
            voList.add(BeanUtil.toArticle(article));
        }

        ArticleListVo vo = new ArticleListVo();
        vo.setArticles(voList);
        return vo;
    }

    public ArticleListVo getPage(int page, int count) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, count, sort);
        Page<ArticleEntity> articlePage = articleDao.findAll(pageable);
        List<ArticleVo> voList = new ArrayList<>();
        for (ArticleEntity article : articlePage) {
            voList.add(BeanUtil.toArticle(article));
        }

        ArticleListVo vo = new ArticleListVo();
        vo.setArticles(voList);
        return vo;
    }

    public BaseVo save(ArticleSaveRequest request) {
        if (request == null) {
            throw new EmptyParamException("articleRequest = null");
        }
        //验证认证码是否有效
        String verifyCode = request.getVerifyCode();
        if(!RandomCodeGenerator.matchVeryfyCode(verifyCode)) {
            throw new RuntimeException("认证码无效");
        }

        //初始化入库的参数
        ArticleEntity article = new ArticleEntity();
        BeanUtils.copyProperties(request, article);
        if (StringUtils.isBlank(article.getCreator())) {
            request.setCreator(TurtleConstants.DEFAULT_USER);
        }
        if (StringUtils.isNotBlank(request.getId())) {
            article.setId(Long.valueOf(request.getId()));
        }
        article.setTemp(TurtleConstants.TEMP_FALSE);
        Date curDate = new Date();
        article.setCreateTime(curDate);
        article.setUpdateTime(curDate);

        //执行存库操作
        article = articleDao.save(article);

        //解析文章标签
        if (StringUtils.isNotBlank(request.getTags())) {
            String[] tagArray = request.getTags().split(",");
            for (String tag : tagArray) {
                List<TagEntity> tagEntityList = tagDao.findByName(tag);
                TagEntity saveTagEntity;
                if (tagEntityList.size() == 0) {
                    saveTagEntity = new TagEntity();
                    saveTagEntity.setName(tag);
                } else {
                    saveTagEntity = tagEntityList.get(0);
                }
                TagArticleEntity saveTagArticleEntity = new TagArticleEntity();
                saveTagArticleEntity.setArticle(article);
                saveTagArticleEntity.setTag(saveTagEntity);
                tagArticleDao.save(saveTagArticleEntity);
            }
        }
        //添加文章后更新缓存
        turtleCache.recache();
        log.info("更新后的cache size = " + TurtleCache.tagMap.size());
        return BeanUtil.success("新建文章成功 ID=" + article.getId());
    }

    public void delete(Long id) {
        articleDao.delete(id);
    }

}
