package com.wj.bean;

import java.util.List;

/**
 * Describe: 部门类
 *
 * @author YoungSmith
 * 18-6-4 下午10:22
 */
public class Department extends CommonBean{
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 描述
     */
    private String describe;
    /**
     * 部门拥有的角色
     */
    private List<Role> roles;
    /**
     * 部门拥有的权限
     */
    private List<Permission> permissions;

    public String getDepartmentName() {
        return departmentName;
    }

    public Department setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public String getDescribe() {
        return describe;
    }

    public Department setDescribe(String describe) {
        this.describe = describe;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public Department setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public Department setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
        return this;
    }
}
