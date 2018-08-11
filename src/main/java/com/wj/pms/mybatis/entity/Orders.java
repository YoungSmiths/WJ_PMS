package com.wj.pms.mybatis.entity;

import java.util.Date;

public class Orders {
    private String id;

    private String orderName;

    private String orderCode;

    private String contractNo;

    private String count;

    private String paperType;

    private String width;

    private String lengths;

    private String printRequire;

    private String outSideHander;

    private String packageRequire;

    private String parts;

    private String designPicPath;

    private String subOrderInfo;

    private String describeInfo;

    private String state;

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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count == null ? null : count.trim();
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

    public String getOutSideHander() {
        return outSideHander;
    }

    public void setOutSideHander(String outSideHander) {
        this.outSideHander = outSideHander == null ? null : outSideHander.trim();
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

    public String getSubOrderInfo() {
        return subOrderInfo;
    }

    public void setSubOrderInfo(String subOrderInfo) {
        this.subOrderInfo = subOrderInfo == null ? null : subOrderInfo.trim();
    }

    public String getDescribeInfo() {
        return describeInfo;
    }

    public void setDescribeInfo(String describeInfo) {
        this.describeInfo = describeInfo == null ? null : describeInfo.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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