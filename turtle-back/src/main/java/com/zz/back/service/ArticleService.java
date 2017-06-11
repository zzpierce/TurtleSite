package com.zz.back.service;

import com.alibaba.fastjson.JSONObject;
import com.zz.back.dao.ArticleDao;
import com.zz.back.model.Article;
import com.zz.back.util.RandomCodeGenerator;
import com.zz.back.util.markrazi.Markrazi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    private static Markrazi markrazi = new Markrazi();

    public Article getById(Long id) {

        Article article = articleDao.findOne(id);
        article.setContent(markrazi.doMarkrazi(article.getContent()));

        return article;

    }

    public List<Article> findByTitle(String title) {
        return articleDao.findByTitle(title);
    }

    public List<Article> findByTags(String tags) {
        return articleDao.findByTags(tags);
    }

    public List<Article> getAll() {
        return (List)articleDao.findAll();
    }

    public Article save(JSONObject articleJson) {

        //verify
        String validateCode = articleJson.getString("verifyCode");
        if(!RandomCodeGenerator.matchValidateCode(validateCode)) {
            throw new RuntimeException("认证码无效");
        }
        
        String title = articleJson.getString("title");
        String content = articleJson.getString("content");
        String summary = articleJson.getString("summary");
        String tags = articleJson.getString("tags");
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setSummary(summary);
        article.setTags(tags);

        Date curDate = new Date();
        article.setCreateTime(curDate);
        article.setUpdateTime(curDate);
        article.setCreator("zzpierce");

        return articleDao.save(article);

    }

    public Article update(Article article) {
        return articleDao.save(article);
    }

    public void delete(Long id) {
        articleDao.delete(id);
    }
}
