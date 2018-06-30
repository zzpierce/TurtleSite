package com.zz.back.model.vo;

import com.zz.back.model.ArticleEntity;
import com.zz.back.util.DateUtil;

/**
 * 文章展示类
 * @author zhanzong
 */
public class ArticleVo extends BaseVo {

    private Long id;

    private String title;

    private String tags;

    private String content;

    private String summary;

    private String createTime;

    private String updateTime;

    private String creator;

    public ArticleVo() {}

    public ArticleVo(ArticleEntity article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.tags = article.getTags();
        this.content = article.getContent();
        this.summary = article.getSummary();
        this.createTime = DateUtil.formatTime(article.getCreateTime());
        this.updateTime = DateUtil.formatTime(article.getUpdateTime());
        this.creator = article.getCreator();
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
