package com.wj.pms.bean;

import java.util.List;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-8-12 上午8:20
 */
public class PermissionBean {
    private List<String> routers;

    public List<String> getRouters() {
        return routers;
    }

    public PermissionBean setRouters(List<String> routers) {
        this.routers = routers;
        return this;
    }
}
