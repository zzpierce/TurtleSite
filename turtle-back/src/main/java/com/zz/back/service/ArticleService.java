package com.zz.back.service;

import com.zz.back.dao.ArticleDao;
import com.zz.back.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public Article getById(Long id) {
        return articleDao.findOne(id);
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
