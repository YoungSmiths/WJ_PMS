package com.wj.pms.common.enums;

/**
 * Describe: 一般分为两种枚举返回状态码枚举</br>
 * 一、通用型
 * 二、业务相关型
 * 此处为通用型
 * @author YoungSmith
 * 18-8-26 下午11:12
 */
public enum BaseResponseCodeEnum {
    SUCCESS("200", "SUCCESS."),
    NO_EXPECTED_NULL("500001", "NOT EXCEPTION NULL."),
    SYSTEM_ERROR("999999", "SYSTEM ERROR.");

    private String code;
    private String message;

    BaseResponseCodeEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
