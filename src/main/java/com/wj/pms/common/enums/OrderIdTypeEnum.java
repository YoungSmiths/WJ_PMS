package com.wj.pms.common.enums;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-9-8 下午4:24
 */
public enum OrderIdTypeEnum {
    Orders(""), Puke("PK"), Box("ZH");
    private String value;

    OrderIdTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
