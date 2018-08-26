package com.wj.pms.common.enums;

/**
 * Describe: 一般分为两种枚举返回状态码枚举</br>
 * 一、通用型
 * 二、业务相关型
 * 此处为业务相关型
 * @author YoungSmith
 * 18-8-26 下午11:24
 */
public enum BusinessResponseCodeEnum {
    USER_NOT_EXISTED("600001", "USER IS NOT EXISTED."),
    FILE_NAME_IS_NULL("600002", "FILE NAME IS NULL");

    private String code;
    private String message;

    BusinessResponseCodeEnum(String code, String message){
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
