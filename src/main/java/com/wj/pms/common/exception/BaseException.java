package com.wj.pms.common.exception;

import com.wj.pms.common.enums.BaseResponseCodeEnum;
import com.wj.pms.common.enums.BusinessResponseCodeEnum;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-8-26 下午10:50
 */
public class BaseException extends RuntimeException{
    private String code;
    private String message;
    private Object data;

    public BaseException(BaseResponseCodeEnum enums, Object data) {
        this.code = enums.getCode();
        this.message = enums.getMessage();
        this.data = data;
    }

    public BaseException(BusinessResponseCodeEnum enums, Object data) {
        this.code = enums.getCode();
        this.message = enums.getMessage();
        this.data = data;
    }

    public BaseException(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseException(String message, String code, String message1, Object data) {
        super(message);
        this.code = code;
        this.message = message1;
        this.data = data;
    }

    public BaseException(String message, Throwable cause, String code, String message1, Object data) {
        super(message, cause);
        this.code = code;
        this.message = message1;
        this.data = data;
    }

    public BaseException(Throwable cause, String code, String message, Object data) {
        super(cause);
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, String message1, Object data) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message1;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public BaseException setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public BaseException setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public BaseException setData(Object data) {
        this.data = data;
        return this;
    }
}
