package com.zz.back.service;

import com.zz.back.dao.ArticleDao;
import com.zz.back.model.Article;
import com.zz.back.util.markrazi.Markrazi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Article save(Article article) {
        return articleDao.save(article);
    }

    public Article update(Article article) {
        return articleDao.save(article);
    }

    public void delete(Long id) {
        articleDao.delete(id);
    }
}
