package com.tex.api.entity;

/**
 *
 * @author shraddhabhatt
 */
public class ErrorEntity {
    
    private String code;
    private String message;

    public ErrorEntity() {}

    public ErrorEntity(String code, String message) {
        this.code = code;
        this.message = message;
    }

    // getters & setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
