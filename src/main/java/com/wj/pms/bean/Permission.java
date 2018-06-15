package com.wj.pms.bean;

/**
 * Describe: 权限类
 *
 * @author YoungSmith
 * 18-6-4 下午10:25
 */
public class Permission extends CommonBean{
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限编码
     */
    private String code;
    /**
     * 权限内容，一般为url
     */
    private String content;

    public String getName() {
        return name;
    }

    public Permission setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Permission setCode(String code) {
        this.code = code;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Permission setContent(String content) {
        this.content = content;
        return this;
    }
}
