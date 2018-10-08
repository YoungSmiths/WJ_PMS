package com.wj.pms.mybatis.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderInfo {
    private BigDecimal id;

    private String orderName;

    private String orderCode;

    private String contractNo;

    private String edition;

    private String customer;

    private String productName;

    private Date orderStartDate;

    private Date deadLine;

    private Integer count;

    private String paperType;

    private String width;

    private String lengths;

    private String printRequire;

    private String outSideHandler;

    private String packageRequire;

    private String parts;

    private String designPicPath;

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

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition == null ? null : edition.trim();
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Date getOrderStartDate() {
        return orderStartDate;
    }

    public void setOrderStartDate(Date orderStartDate) {
        this.orderStartDate = orderStartDate;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType == null ? null : paperType.trim();
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width == null ? null : width.trim();
    }

    public String getLengths() {
        return lengths;
    }

    public void setLengths(String lengths) {
        this.lengths = lengths == null ? null : lengths.trim();
    }

    public String getPrintRequire() {
        return printRequire;
    }

    public void setPrintRequire(String printRequire) {
        this.printRequire = printRequire == null ? null : printRequire.trim();
    }

    public String getOutSideHandler() {
        return outSideHandler;
    }

    public void setOutSideHandler(String outSideHandler) {
        this.outSideHandler = outSideHandler == null ? null : outSideHandler.trim();
    }

    public String getPackageRequire() {
        return packageRequire;
    }

    public void setPackageRequire(String packageRequire) {
        this.packageRequire = packageRequire == null ? null : packageRequire.trim();
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts == null ? null : parts.trim();
    }

    public String getDesignPicPath() {
        return designPicPath;
    }

    public void setDesignPicPath(String designPicPath) {
        this.designPicPath = designPicPath == null ? null : designPicPath.trim();
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