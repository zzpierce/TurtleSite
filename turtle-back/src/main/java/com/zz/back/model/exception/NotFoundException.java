package com.zz.back.model.exception;

/**
 * @author pierce
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
