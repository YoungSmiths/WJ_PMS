package com.wj.pms.bean;

import java.util.Date;

/**
 * Describe: 审计字段
 *
 * @author YoungSmith
 * 18-6-4 下午10:32
 */
public class Auditor {
    /**
     * 创建者
     */
    private String create_by;
    /**
     * 最近更新人
     */
    private String update_by;
    /**
     * 创建时间
     */
    private Date date_create;
    /**
     * 最近一次更新时间
     */
    private Date date_update;

    public String getCreate_by() {
        return create_by;
    }

    public Auditor setCreate_by(String create_by) {
        this.create_by = create_by;
        return this;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public Auditor setUpdate_by(String update_by) {
        this.update_by = update_by;
        return this;
    }

    public Date getDate_create() {
        return date_create;
    }

    public Auditor setDate_create(Date date_create) {
        this.date_create = date_create;
        return this;
    }

    public Date getDate_update() {
        return date_update;
    }

    public Auditor setDate_update(Date date_update) {
        this.date_update = date_update;
        return this;
    }
}
