package com.wj.bean;

import javafx.util.Pair;

import java.util.Date;
import java.util.List;

/**
 * Describe: 详细订单
 *
 * @author YoungSmith
 * 18-6-4 下午11:12
 */
public class DetailOrder extends CommonBean{

    /**
     * 客户联系人
     */
    private String customerName;
    /**
     * 下单日期
     */
    private Date startDate;
    /**
     * 版次
     */
    private String banci;
    /**
     * 交货日期
     */
    private Date endDate;
    /**
     * 文件批次
     */
    private String wenjianpici;
    /**
     * 包装
     */
    private String baozhuang;
    /**
     * 特别说明
     */
    private String tebieshuoming;

    /**
     * 订单中扑克
     */
    private List<puke> pukes;
    /**
     * 订单中盒子
     */
    private List<Hezi> hezis;
    /**
     * 订单中盒子和扑克匹配列表
     */
    private List<Pair<puke,Hezi>> pairs;

    public String getCustomerName() {
        return customerName;
    }

    public DetailOrder setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public DetailOrder setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getBanci() {
        return banci;
    }

    public DetailOrder setBanci(String banci) {
        this.banci = banci;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public DetailOrder setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getWenjianpici() {
        return wenjianpici;
    }

    public DetailOrder setWenjianpici(String wenjianpici) {
        this.wenjianpici = wenjianpici;
        return this;
    }

    public String getBaozhuang() {
        return baozhuang;
    }

    public DetailOrder setBaozhuang(String baozhuang) {
        this.baozhuang = baozhuang;
        return this;
    }

    public String getTebieshuoming() {
        return tebieshuoming;
    }

    public DetailOrder setTebieshuoming(String tebieshuoming) {
        this.tebieshuoming = tebieshuoming;
        return this;
    }

    public List<puke> getPukes() {
        return pukes;
    }

    public DetailOrder setPukes(List<puke> pukes) {
        this.pukes = pukes;
        return this;
    }

    public List<Hezi> getHezis() {
        return hezis;
    }

    public DetailOrder setHezis(List<Hezi> hezis) {
        this.hezis = hezis;
        return this;
    }

    public List<Pair<puke, Hezi>> getPairs() {
        return pairs;
    }

    public DetailOrder setPairs(List<Pair<puke, Hezi>> pairs) {
        this.pairs = pairs;
        return this;
    }
}
