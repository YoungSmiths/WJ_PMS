package com.wj.pms.mybatis.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CardOrdersInfo {
    private BigDecimal id;

    private String cardOrderName;

    private String cardOrderCode;

    private String versionHouse;

    private String openPaper;

    private String print;

    private String outSideHander;

    private String openCard;

    private String bluntCard;

    private String describeInfo;

    private String status;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCardOrderName() {
        return cardOrderName;
    }

    public void setCardOrderName(String cardOrderName) {
        this.cardOrderName = cardOrderName == null ? null : cardOrderName.trim();
    }

    public String getCardOrderCode() {
        return cardOrderCode;
    }

    public void setCardOrderCode(String cardOrderCode) {
        this.cardOrderCode = cardOrderCode == null ? null : cardOrderCode.trim();
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