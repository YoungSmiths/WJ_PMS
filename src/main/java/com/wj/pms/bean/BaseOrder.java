package com.wj.pms.bean;

/**
 * Describe: 订单
 *
 * @author YoungSmith
 * 18-6-4 下午10:46
 */
public class BaseOrder extends CommonBean{
    /**
     * 货品名称
     */
    private String name;
    /**
     * 合同 TODO：
     */
    private String hetong;
    /**
     * 订单数量
     */
    private Integer count;
    /**
     * 用纸类型
     */
    private String paperType;
    /**
     * 扑克宽度
     */
    private Float width;
    /**
     * 扑克长度
     */
    private Float length;
    /**
     * 打印要求
     */
    private String printRequire;
    /**
     * 表面处理
     */
    private String dealOutSide;
    /**
     * 包装要求
     */
    private String baozhuangRequire;
    /**
     * 配件
     */
    private String peijian;
    /**
     * 描述
     */
    private String describe;

    public String getName() {
        return name;
    }

    public BaseOrder setName(String name) {
        this.name = name;
        return this;
    }

    public String getHetong() {
        return hetong;
    }

    public BaseOrder setHetong(String hetong) {
        this.hetong = hetong;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public BaseOrder setCount(Integer count) {
        this.count = count;
        return this;
    }

    public String getPaperType() {
        return paperType;
    }

    public BaseOrder setPaperType(String paperType) {
        this.paperType = paperType;
        return this;
    }

    public Float getWidth() {
        return width;
    }

    public BaseOrder setWidth(Float width) {
        this.width = width;
        return this;
    }

    public Float getLength() {
        return length;
    }

    public BaseOrder setLength(Float length) {
        this.length = length;
        return this;
    }

    public String getPrintRequire() {
        return printRequire;
    }

    public BaseOrder setPrintRequire(String printRequire) {
        this.printRequire = printRequire;
        return this;
    }

    public String getDealOutSide() {
        return dealOutSide;
    }

    public BaseOrder setDealOutSide(String dealOutSide) {
        this.dealOutSide = dealOutSide;
        return this;
    }

    public String getBaozhuangRequire() {
        return baozhuangRequire;
    }

    public BaseOrder setBaozhuangRequire(String baozhuangRequire) {
        this.baozhuangRequire = baozhuangRequire;
        return this;
    }

    public String getPeijian() {
        return peijian;
    }

    public BaseOrder setPeijian(String peijian) {
        this.peijian = peijian;
        return this;
    }

    public String getDescribe() {
        return describe;
    }

    public BaseOrder setDescribe(String describe) {
        this.describe = describe;
        return this;
    }
}
