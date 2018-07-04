package com.zz.back.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 前后端交互基础类
 * @author zhanzong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseVo<T> {

    private int code;

    private String message;

    private T data;
}
