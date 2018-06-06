package com.wj.bean;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-6-4 下午11:21
 */
public class Action extends CommonBean{
    /**
     * 行为名称
     */
    private String name;
    /**
     * 行为内容
     */
    private String content;

    public String getName() {
        return name;
    }

    public Action setName(String name) {
        this.name = name;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Action setContent(String content) {
        this.content = content;
        return this;
    }
}
