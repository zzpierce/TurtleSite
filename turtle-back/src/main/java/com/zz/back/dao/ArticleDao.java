package com.zz.back.dao;

import com.zz.back.model.Article;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ArticleDao extends CrudRepository<Article, Long> {

    public List<Article> findByTitle(String title);

    public List<Article> findByTags(String tags);

}
