package com.zz.back.service;

import com.alibaba.fastjson.JSONObject;
import com.zz.back.dao.ArticleDao;
import com.zz.back.dao.TagArticleDao;
import com.zz.back.dao.TagDao;
import com.zz.back.model.Article;
import com.zz.back.model.vo.ArticleListVo;
import com.zz.back.model.vo.ArticleVo;
import com.zz.back.model.vo.BaseVo;
import com.zz.back.util.RandomCodeGenerator;
import com.zz.back.util.TurtleConstants;
import com.zz.back.util.cache.TurtleCache;
import com.zz.back.util.markrazi.Markrazi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    @Resource
    private ArticleDao articleDao;

    @Resource
    private TagArticleDao tagArticleDao;

    @Resource
    private TagDao tagDao;

    private static Markrazi markrazi = new Markrazi();

    /**
     * 通过ID获取文章，内容为HTML格式
     * @param id id
     * @return 文章
     */
    public ArticleVo getById(Long id, String format) {
        Article article = articleDao.findOne(id);
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

    /**
     * 通过标题获取文章
     * @param title 标题
     * @return 文章列表
     */
    public List<Article> findByTitle(String title) {
        return articleDao.findByTitle(title);
    }

    /**
     * 通过标签获取文章
     * @param tag 标签
     * @return 文章列表
     */
    public ArticleListVo findByTag(String tag) {

        ArticleListVo vo = new ArticleListVo();
        vo.setCode(TurtleConstants.RESULT_SUCCESS);
        if (!TurtleCache.tagMap.containsKey(tag)) {
            vo.setArticles(new ArrayList<>());
            return vo;
        }

        Long id = TurtleCache.tagMap.get(tag);
        List<Article> articleList = tagArticleDao.findByTagId(id);
        List<ArticleVo> voList = new ArrayList<>();
        for (Article article : articleList) {
            voList.add(new ArticleVo(article));
        }

        vo.setArticles(voList);
        return vo;
    }

    /**
     * 获取所有文章，不包括临时文章
     * @return 文章列表
     */
    public ArticleListVo getAll() {
        List<Article> articleList = articleDao.findByTempEqualsOrderByIdDesc(TurtleConstants.TEMP_FALSE);
        List<ArticleVo> voList = new ArrayList<>();
        for (Article article : articleList) {
            voList.add(new ArticleVo(article));
        }

        ArticleListVo vo = new ArticleListVo();
        vo.setArticles(voList);
        vo.setCode(TurtleConstants.RESULT_SUCCESS);
        return vo;
    }

    /**
     * 保存文章
     * @param articleJson 文章
     * @return 是否成功
     */
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

        Article article = new Article();
        if (StringUtils.isNotBlank(id)) {
            article.setId(Long.valueOf(id));
        }

        article.setTitle(title);
        article.setContent(content);
        article.setSummary(summary);
        article.setTags(tags);
        article.setTemp(TurtleConstants.TEMP_FALSE);

        Date curDate = new Date();
        article.setCreateTime(curDate);
        article.setUpdateTime(curDate);
        article.setCreator(creator);

        article = articleDao.save(article);

        return new BaseVo(TurtleConstants.RESULT_SUCCESS, "新建文章成功 ID=" + article.getId());
    }

    public void delete(Long id) {
        articleDao.delete(id);
    }

}
