package com.zz.back.dao;

import com.zz.back.model.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 文章的数据库操作类
 */
public interface ArticleDao extends CrudRepository<Article, Long> {

    /**
     * 根据文章标题获取文章
     * @param title 文章标题
     * @return 文章列表
     */
    List<Article> findByTitle(String title);

    /**
     * 根据文章标签获取文章
     * @param tagId 标签Id
     * @return 文章列表
     */
    @Query("select a from article a where id = ?1")
    List<Article> findByTagId(Long tagId);

    /**
     * 根据临时标识获取文章，时间逆序
     * @param temp 临时标识
     * @return 文章列表
     */
    List<Article> findByTempEqualsOrderByIdDesc(int temp);


}
