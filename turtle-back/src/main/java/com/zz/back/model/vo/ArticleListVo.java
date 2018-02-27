package com.zz.back.model.vo;

import java.util.List;

/**
 * 文章列表交互类
 * @author zhanzong
 */
public class ArticleListVo extends BaseVo {

    private List<ArticleVo> articles;

    public List<ArticleVo> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleVo> articles) {
        this.articles = articles;
    }
}
