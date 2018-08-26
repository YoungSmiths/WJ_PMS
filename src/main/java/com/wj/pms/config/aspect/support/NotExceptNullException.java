package com.wj.pms.config.aspect.support;


import com.wj.pms.common.enums.BaseResponseCodeEnum;
import com.wj.pms.common.enums.BusinessResponseCodeEnum;
import com.wj.pms.common.exception.BaseException;

public class NotExceptNullException extends BaseException{
	public NotExceptNullException(BaseResponseCodeEnum enums, Object data) {
		super(enums, data);
	}

	public NotExceptNullException(BusinessResponseCodeEnum enums, Object data) {
		super(enums, data);
	}

	public NotExceptNullException(String code, String message, Object data) {
		super(code, message, data);
	}

	public NotExceptNullException(String message, String code, String message1, Object data) {
		super(message, code, message1, data);
	}

	public NotExceptNullException(String message, Throwable cause, String code, String message1, Object data) {
		super(message, cause, code, message1, data);
	}

	public NotExceptNullException(Throwable cause, String code, String message, Object data) {
		super(cause, code, message, data);
	}

	public NotExceptNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, String message1, Object data) {
		super(message, cause, enableSuppression, writableStackTrace, code, message1, data);
	}
}
