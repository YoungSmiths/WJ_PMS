package com.wj.pms.bean;

import com.wj.pms.mybatis.entity.DepartmentInfo;
import com.wj.pms.mybatis.entity.PermissionInfo;
import com.wj.pms.mybatis.entity.RoleInfo;
import com.wj.pms.mybatis.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-9-2 下午8:16
 */
public class UserBean {
    private UserInfo user;
    private DepartmentInfo department;
    private List<RoleInfo> roles;
    private List<PermissionInfo> permissions;

    public UserBean(UserInfo user, DepartmentInfo department, List<RoleInfo> roles, List<PermissionInfo> permissions) {
        this.user = user;
        this.department = department;
        this.roles = roles;
        this.permissions = permissions;
    }

    public UserBean(){

    }

    public UserInfo getUser() {
        return user;
    }

    public UserBean setUser(UserInfo user) {
        this.user = user;
        return this;
    }

    public DepartmentInfo getDepartment() {
        return department;
    }

    public UserBean setDepartment(DepartmentInfo department) {
        this.department = department;
        return this;
    }

    public List<RoleInfo> getRoles() {
        return roles;
    }

    public UserBean setRoles(List<RoleInfo> roles) {
        this.roles = roles;
        return this;
    }

    public List<PermissionInfo> getPermissions() {
        return permissions;
    }

    public UserBean setPermissions(List<PermissionInfo> permissions) {
        this.permissions = permissions;
        return this;
    }

}
