package com.zz.back.dao;

import com.zz.back.model.Article;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ArticleDao extends CrudRepository<Article, Long> {

    public Article findByTitle(String title);

}
