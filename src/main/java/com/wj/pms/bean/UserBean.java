package com.wj.pms.bean;

import com.wj.pms.mybatis.entity.Department;
import com.wj.pms.mybatis.entity.Role;
import com.wj.pms.mybatis.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-9-2 下午8:16
 */
public class UserBean {
    private User user;
    private Department department;
    private List<Role> roles;
    private Map<String, Object> permissions;

    public UserBean(User user, Department department, List<Role> roles, Map<String, Object> permissions) {
        this.user = user;
        this.department = department;
        this.roles = roles;
        this.permissions = permissions;
    }

    public UserBean(){

    }

    public User getUser() {
        return user;
    }

    public UserBean setUser(User user) {
        this.user = user;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public UserBean setDepartment(Department department) {
        this.department = department;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public UserBean setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public Map<String, Object> getPermissions() {
        return permissions;
    }

    public UserBean setPermissions(Map<String, Object> permissions) {
        this.permissions = permissions;
        return this;
    }

}
