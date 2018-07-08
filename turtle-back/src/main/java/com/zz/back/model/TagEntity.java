package com.zz.back.model;

import lombok.Data;
import javax.persistence.*;

/**
 * 标签类
 * @author zhanzong
 */
@Data
@Entity
@Table(name="tag")
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

}
