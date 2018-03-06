package com.zz.back.dao;

import com.zz.back.model.Article;
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
     * 根据临时标识获取文章，时间逆序
     * @param temp 临时标识
     * @return 文章列表
     */
    List<Article> findByTempEqualsOrderByIdDesc(int temp);

}
