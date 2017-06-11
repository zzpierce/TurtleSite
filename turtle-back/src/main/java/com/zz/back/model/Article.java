package com.zz.back.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String tags;

    private String content;

    private String summary;

    private Date createTime;

    private Date updateTime;

    private String creator;

    public Article() {}

    public Article(Long id) {
        this.id = id;
    }

    public Article(String title, String tags, String content, String summary, Date createTime, Date updateTime, String creator) {
        this.title = title;
        this.tags = tags;
        this.content = content;
        this.summary = summary;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

}
