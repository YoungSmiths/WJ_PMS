package com.wj.pms.common.exception;

/**
 * @ClassName: PmsException
 * @Description: TODO Service层处理各类异常
 * @author shiy
 * @date 2017年3月4日 上午9:13:19
 */
public class PmsException extends Exception {

	private static final long serialVersionUID = -2542781959794576600L;

	/** 错误码 */
	protected int errorCode;

	/** 错误提示信息 */
	protected String errorMsg;

	/** 额外信息 */
	protected Object data;

	public PmsException(Exception e) {
		super(e);
	}

	public PmsException(int errorCode, String errorMsg) {
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
	}

	public PmsException(int errorCode, String errorMsg, Object data) {
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
		this.data = data;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}
}
