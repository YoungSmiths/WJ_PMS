package com.youngsmith.dev.controller;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-6-13 下午9:31
 */
public class AjaxResultDTO {
    private String code;
    private String message;
    private Object data;

    @Override
    public String toString() {
        return "AjaxResultDTO{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public AjaxResultDTO(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public AjaxResultDTO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public AjaxResultDTO setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public AjaxResultDTO setData(Object data) {
        this.data = data;
        return this;
    }
}
