package com.wj.pms.common;


import com.wj.pms.common.enums.BaseResponseCodeEnum;
import com.wj.pms.common.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 *
 */
public class Result implements Serializable{

    private String code;
    private String message;
    private Object data;

    private static String SUCCESS_CODE = BaseResponseCodeEnum.SUCCESS.getCode();
    private static String SUCCESS_MESSAGE = BaseResponseCodeEnum.SUCCESS.getMessage();

    public Result(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public Result setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    public static Result success(Object data) {
        return new Result(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static Result success() {
        return success(null);
    }

    public static Result fail(String code, String message, Object data) {
        return new Result(code, message, data) ;
    }

    public static Result fail(BaseException e) {
        return fail(e.getCode(), e.getMessage(), e.getData());
    }

    public static Result buildResponse(HttpServletResponse response, Cookie cookie, String code, String message, Object data) {
        response.addCookie(cookie);
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON.toString());
        return Result.fail(code, message, data);
    }
}