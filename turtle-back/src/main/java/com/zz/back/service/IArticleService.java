package com.zz.back.service;

import com.alibaba.fastjson.JSONObject;
import com.zz.back.model.ArticleEntity;
import com.zz.back.model.request.ArticleSaveRequest;
import com.zz.back.model.vo.ArticleListVo;
import com.zz.back.model.vo.ArticleVo;
import com.zz.back.model.vo.BaseVo;

import java.util.List;

/**
 * @author pierce
 */
public interface IArticleService {

    /**
     * 通过ID获取文章，内容为HTML格式
     * @param id id
     * @return 文章
     */
    ArticleVo getById(Long id, String format);

    /**
     * 通过标题获取文章
     * @param title 标题
     * @return 文章列表
     */
    List<ArticleEntity> findByTitle(String title);

    /**
     * 通过标签获取文章
     * @param tag 标签
     * @return 文章列表
     */
    ArticleListVo findByTag(String tag);

    /**
     * 获取所有文章，不包括临时文章
     * @return 文章列表
     */
    ArticleListVo getAll();

    /**
     * 按页获取文章
     * @param page 页数
     * @param count 一页多少个
     * @return 文章列表
     */
    ArticleListVo getPage(int page, int count);

    /**
     * 保存文章
     * @param request 文章
     * @return 是否成功
     */
    BaseVo save(ArticleSaveRequest request);

    /**
     * 删除文章
     * @param id 文章id
     */
    void delete(Long id);
}
