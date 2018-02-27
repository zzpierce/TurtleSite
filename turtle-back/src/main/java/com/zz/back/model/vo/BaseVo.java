package com.zz.back.model.vo;

/**
 * 前后端交互基础类
 * @author zhanzong
 */
public class BaseVo {

    private int code;

    private String message;

    public BaseVo() {
    }

    public BaseVo(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
