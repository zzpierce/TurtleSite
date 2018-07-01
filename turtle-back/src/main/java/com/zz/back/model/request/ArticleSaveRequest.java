package com.zz.back.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleSaveRequest extends VerifyRequest {

    private String id;

    private String title;

    private String content;

    private String summary;

    private Date createTime;

    private Date updateTime;

    private String creator;

    private Integer temp;

    private String tags;
}
