package com.zz.back.dao;

import com.zz.back.model.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 负责标签和文章相关的数据类
 * @author zhanzong
 */
public interface TagArticleDao extends CrudRepository<Article, Long>{

    /**
     * 根据文章标签id获取文章
     * @param tagId 标签id
     * @return 文章列表
     */
    @Query("select ta.article from TagArticle ta inner join ta.article where ta.tagId = ?1")
    List<Article> findByTagId(Long tagId);

}
