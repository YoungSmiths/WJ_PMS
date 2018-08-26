package com.wj.pms.common.exception;

import com.wj.pms.common.enums.BaseResponseCodeEnum;
import com.wj.pms.common.enums.BusinessResponseCodeEnum;

/**
 * Describe: controller 交互层异常
 *
 * @author YoungSmith
 * 18-8-26 下午11:29
 */
public class ViewException extends BaseException{
    public ViewException(BaseResponseCodeEnum enums, Object data) {
        super(enums, data);
    }

    public ViewException(BusinessResponseCodeEnum enums, Object data) {
        super(enums, data);
    }

    public ViewException(String code, String message, Object data) {
        super(code, message, data);
    }

    public ViewException(String message, String code, String message1, Object data) {
        super(message, code, message1, data);
    }

    public ViewException(String message, Throwable cause, String code, String message1, Object data) {
        super(message, cause, code, message1, data);
    }

    public ViewException(Throwable cause, String code, String message, Object data) {
        super(cause, code, message, data);
    }

    public ViewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, String message1, Object data) {
        super(message, cause, enableSuppression, writableStackTrace, code, message1, data);
    }
}
