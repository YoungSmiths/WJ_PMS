package com.wj.pms.common.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class UserOperationRecord extends BaseEntity<UserOperationRecord> {
    @ManyToOne
    private User user; // The operation user.

    // The following are the operation target, like '/Node/1', '/AlertEvent/3',  etc.
    private String target;

    // The operation type, like LOGIN, CREATE, CHANGE, CONFIRM.
    private String action;

    // Changed field old value, json format.
    private String oldContent;

    // changed field new value json format.
    private String newContent;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getOldContent() {
        return oldContent;
    }

    public void setOldContent(String oldContent) {
        this.oldContent = oldContent;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }
}

