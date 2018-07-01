package com.zz.back.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 文章实体类
 * @author zhanzong
 */
@Data
@Entity
@Table(name="article")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

    private String summary;

    private Date createTime;

    private Date updateTime;

    private String creator;

    private Integer temp;

}
