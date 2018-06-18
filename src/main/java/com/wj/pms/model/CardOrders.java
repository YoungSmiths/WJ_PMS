package com.wj.pms.model;

import java.util.Date;

public class CardOrders {
    private Integer id;

    private String name;

    private String code;

    private String parentOrderId;

    private String versionHouse;

    private String openPaper;

    private String print;

    private String outSideHander;

    private String openCard;

    private String bluntCard;

    private String describeInfo;

    private String status;

    private String createBy;

    private Date dateCreated;

    private String updateBy;

    private Date dateUpdated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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

    public String getOpenCard() {
        return openCard;
    }

    public void setOpenCard(String openCard) {
        this.openCard = openCard == null ? null : openCard.trim();
    }

    public String getBluntCard() {
        return bluntCard;
    }

    public void setBluntCard(String bluntCard) {
        this.bluntCard = bluntCard == null ? null : bluntCard.trim();
    }

    public String getDescribeInfo() {
        return describeInfo;
    }

    public void setDescribeInfo(String describeInfo) {
        this.describeInfo = describeInfo == null ? null : describeInfo.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}