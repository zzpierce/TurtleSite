package com.zz.back.model.vo;

import com.zz.back.model.ArticleEntity;
import com.zz.back.util.DateUtil;
import lombok.Data;

import java.util.Date;

/**
 * 文章展示类
 * @author zhanzong
 */
@Data
public class ArticleVo {

    private Long id;

    private String title;

    private String tags;

    private String content;

    private String summary;

    private Date createTime;

    private Date updateTime;

    private String creator;

}
