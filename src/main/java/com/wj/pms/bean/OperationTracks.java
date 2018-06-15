package com.wj.pms.bean;

/**
 * Describe: 操作记录表
 *
 * @author YoungSmith
 * 18-6-4 下午11:20
 */
public class OperationTracks extends CommonBean{
    /**
     * 操作人
     */
    private User user;
    /**
     * 操作
     */
    private Action action;

    public User getUser() {
        return user;
    }

    public OperationTracks setUser(User user) {
        this.user = user;
        return this;
    }

    public Action getAction() {
        return action;
    }

    public OperationTracks setAction(Action action) {
        this.action = action;
        return this;
    }
}
