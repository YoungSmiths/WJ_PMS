package com.wj.pms.bean;

import java.util.List;

/**
 * Describe: 角色类
 *
 * @author YoungSmith
 * 18-6-4 下午10:20
 */
public class Role extends CommonBean{
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色拥有的权限
     */
    private List<Permission> permissions;
    /**
     * 角色是否在使用
     */
    private boolean isUsing;

    public String getRoleName() {
        return roleName;
    }

    public Role setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public Role setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
        return this;
    }

    public boolean isUsing() {
        return isUsing;
    }

    public Role setUsing(boolean using) {
        isUsing = using;
        return this;
    }
}
