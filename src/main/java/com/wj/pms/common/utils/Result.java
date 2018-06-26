package com.wj.pms.common.utils;


import com.wj.pms.common.exception.PmsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YoungSmith on 2018/2/13.
 */
public class Result {
    private int code;
    private String message;
    private Object data;

    public static int SUCCESS_CODE = 0;

    public static int FAILED_CODE = -1;

    public Result() {
        super();
    }

    public Result(int code) {
        super();
        this.code = code;
    }

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(int code, String message) {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public static Result success(Object data) {
        return new Result(SUCCESS_CODE, "OK", data);
    }

    public static Result success() {
        return new Result(SUCCESS_CODE, "OK");
    }

    public static Result fail(PmsException e) {
        return new Result(e.getErrorCode(), e.getMessage(), e.getData());
    }

    public static Result fail(Exception e) {
        return new Result(FAILED_CODE, e.getClass().getCanonicalName(), e.getMessage());
    }

    public static Result fail(String msg) {
        return new Result(FAILED_CODE, msg);
    }


    public static Result buildSuccessResult() {
        return buildSuccessResult("");
    }

    public static Result buildSuccessResult(Object data) {
        return buildResult(0, "", data);
    }

    public static Result buildSuccessResult(int code, Object data) {
        return buildResult(code, "", data);
    }

    public static Result buildFailResult(int code, String message) {
        return buildResult(code, message, "");
    }

    public static Result buildResult(int code, String message, Object data) {
        Result result = new Result(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static Result buildFailResponse(HttpServletResponse response, Cookie cookie, int code, String message) {
        response.addCookie(cookie);
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON.toString());
        return Result.buildFailResult(code, message);
    }

    public static Result buildFailResponse(HttpServletResponse response, int code, String message) {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON.toString());
        return Result.buildFailResult(code, message);
    }

    public static Result buildResponse(HttpServletResponse response, Cookie cookie, int code, String message, Object data) {
        response.addCookie(cookie);
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON.toString());
        return Result.buildResult(code, message, data);
    }
}
