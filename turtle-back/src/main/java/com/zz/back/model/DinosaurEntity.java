package com.zz.back.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author pierce
 */
@Data
@Entity
@Table(name="dinosaur")
public class DinosaurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String picName;

    private Integer width;

    private Integer height;

}
