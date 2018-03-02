package com.zz.back.model;

import javax.persistence.*;

/**
 * 文章和标签的关系类
 * @author zhanzong
 */
@Entity
@Table(name="tag_article")
public class TagArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long tagId;

    private Long articleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}
