package com.zz.back.model;

import lombok.Data;

import javax.persistence.*;

/**
 * 文章和标签的关系类
 * @author zhanzong
 */
@Data
@Entity
@Table(name = "tag_article")
public class TagArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "tag_id")
    private TagEntity tag;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "article_id")
    private ArticleEntity article;

}
