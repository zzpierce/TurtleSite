package com.zz.back.dao;

import com.zz.back.model.TagArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 负责标签和文章相关的数据类
 * @author zhanzong
 */
public interface TagArticleDao extends JpaRepository<TagArticleEntity, Long> {

    /**
     * 根据文章标签id获取文章
     * @param tagId 标签id
     * @return 文章列表
     */
    @Query("select ta.tag from TagArticleEntity ta inner join ta.tag where ta.tag = ?1")
    List<TagArticleEntity> findByTagId(Long tagId);

    @Query("select ta.article from TagArticleEntity ta inner join ta.article where ta.article = ?1")
    List<TagArticleEntity> findByArticleId(Long articleId);
}
