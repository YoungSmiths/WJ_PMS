package com.wj.pms.common.model;

import javax.persistence.Entity;

@Entity
public class UserDescription extends BaseEntity<UserDescription> {

    private String userName; // 用户名
    private String name ; // 用户姓名
    private String dept; //  部门

    public String getUserName() {
        return userName;
    }

    public UserDescription setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDescription setName(String name) {
        this.name = name;
        return this;
    }

    public String getDept() {
        return dept;
    }

    public UserDescription setDept(String dept) {
        this.dept = dept;
        return this;
    }
}
