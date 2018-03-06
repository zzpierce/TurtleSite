package com.zz.back.model;

import javax.persistence.*;

/**
 * 文章和标签的关系类
 * @author zhanzong
 */
@Entity
@Table(name = "tag_article")
public class TagArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long tagId;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "article_id")
    private Article article;

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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
