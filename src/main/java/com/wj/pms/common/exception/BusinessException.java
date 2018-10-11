package com.wj.pms.common.exception;

import com.wj.pms.common.enums.BaseResponseCodeEnum;
import com.wj.pms.common.enums.BusinessResponseCodeEnum;

/**
 * Describe: 业务层异常
 *
 * @author YoungSmith
 * 18-8-26 下午10:49
 */
public class BusinessException extends BaseException{
    public BusinessException(BaseResponseCodeEnum enums, Object data) {
        super(enums, data);
    }

    public BusinessException(BusinessResponseCodeEnum enums, Object data) {
        super(enums, data);
    }

    public BusinessException() {
        super(code, message, data);
    }

    public BusinessException(String message, String code, String message1, Object data) {
        super(message, code, message1, data);
    }

    public BusinessException(String message, Throwable cause, String code, String message1, Object data) {
        super(message, cause, code, message1, data);
    }

    public BusinessException(Throwable cause, String code, String message, Object data) {
        super(cause, code, message, data);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, String message1, Object data) {
        super(message, cause, enableSuppression, writableStackTrace, code, message1, data);
    }
}
