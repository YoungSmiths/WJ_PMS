package com.wj.pms.mybatis.entity;

import java.util.Date;

public class BoxOrder {
    private String id;

    private String boxOrderName;

    private String boxOrderCode;

    private String parentOrderId;

    private String versionHouse;

    private String openPaper;

    private String print;

    private String outSideHander;

    private String boxBeer;

    private String boxSticky;

    private String state;

    private String describeInfo;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBoxOrderName() {
        return boxOrderName;
    }

    public void setBoxOrderName(String boxOrderName) {
        this.boxOrderName = boxOrderName == null ? null : boxOrderName.trim();
    }

    public String getBoxOrderCode() {
        return boxOrderCode;
    }

    public void setBoxOrderCode(String boxOrderCode) {
        this.boxOrderCode = boxOrderCode == null ? null : boxOrderCode.trim();
    }

    public String getParentOrderId() {
        return parentOrderId;
    }

    public void setParentOrderId(String parentOrderId) {
        this.parentOrderId = parentOrderId == null ? null : parentOrderId.trim();
    }

    public String getVersionHouse() {
        return versionHouse;
    }

    public void setVersionHouse(String versionHouse) {
        this.versionHouse = versionHouse == null ? null : versionHouse.trim();
    }

    public String getOpenPaper() {
        return openPaper;
    }

    public void setOpenPaper(String openPaper) {
        this.openPaper = openPaper == null ? null : openPaper.trim();
    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print == null ? null : print.trim();
    }

    public String getOutSideHander() {
        return outSideHander;
    }

    public void setOutSideHander(String outSideHander) {
        this.outSideHander = outSideHander == null ? null : outSideHander.trim();
    }

    public String getBoxBeer() {
        return boxBeer;
    }

    public void setBoxBeer(String boxBeer) {
        this.boxBeer = boxBeer == null ? null : boxBeer.trim();
    }

    public String getBoxSticky() {
        return boxSticky;
    }

    public void setBoxSticky(String boxSticky) {
        this.boxSticky = boxSticky == null ? null : boxSticky.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getDescribeInfo() {
        return describeInfo;
    }

    public void setDescribeInfo(String describeInfo) {
        this.describeInfo = describeInfo == null ? null : describeInfo.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}