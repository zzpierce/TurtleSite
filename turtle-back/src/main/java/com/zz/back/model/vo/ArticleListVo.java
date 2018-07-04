package com.zz.back.model.vo;

import lombok.Data;

import java.util.List;

/**
 * 文章列表交互类
 * @author zhanzong
 */
@Data
public class ArticleListVo {

    private List<ArticleVo> articles;

}
