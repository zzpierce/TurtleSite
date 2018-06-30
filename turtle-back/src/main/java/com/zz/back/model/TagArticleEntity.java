package com.zz.back.model;

import javax.persistence.*;

/**
 * 文章和标签的关系类
 * @author zhanzong
 */
@Entity
@Table(name = "tag_article")
public class TagArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long tagId;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "article_id")
    private ArticleEntity article;

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

    public ArticleEntity getArticle() {
        return article;
    }

    public void setArticle(ArticleEntity article) {
        this.article = article;
    }
}
