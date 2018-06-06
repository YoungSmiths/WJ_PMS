package com.wj.bean;

/**
 * Describe: 异常信息表
 *
 * @author YoungSmith
 * 18-6-4 下午11:22
 */
public class ExceptionInfo extends CommonBean{
    /**
     * 在哪个操作产生的异常
     */
    private Action action;
    /**
     * 异常的内容
     */
    private String errorContent;
    /**
     * 哪位用户操作是产生的异常
     */
    private User user;

    public Action getAction() {
        return action;
    }

    public ExceptionInfo setAction(Action action) {
        this.action = action;
        return this;
    }

    public String getErrorContent() {
        return errorContent;
    }

    public ExceptionInfo setErrorContent(String errorContent) {
        this.errorContent = errorContent;
        return this;
    }

    public User getUser() {
        return user;
    }

    public ExceptionInfo setUser(User user) {
        this.user = user;
        return this;
    }
}
