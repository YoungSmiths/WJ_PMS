package com.wj.pms.bean;

/**
 * Describe: 扑克
 *
 * @author YoungSmith
 * 18-6-4 下午10:56
 */
public class puke {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 扑克名称
     */
    private String name;

    /**
     * 所属订单
     */
    private BaseOrder baseOrder;

    /**
     * 版房
     */
    private String banfang;
    /**
     * 开纸
     */
    private String kaizhi;
    /**
     * 印刷
     */
    private String yinshua;
    /**
     * 表面处理
     */
    private String dealoutSide;
    /**
     * 啤盒
     */
    private String pihe;
    /**
     * 黏盒
     */
    private String nianhe;

    public Integer getId() {
        return id;
    }

    public puke setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public puke setName(String name) {
        this.name = name;
        return this;
    }

    public BaseOrder getBaseOrder() {
        return baseOrder;
    }

    public puke setBaseOrder(BaseOrder baseOrder) {
        this.baseOrder = baseOrder;
        return this;
    }

    public String getBanfang() {
        return banfang;
    }

    public puke setBanfang(String banfang) {
        this.banfang = banfang;
        return this;
    }

    public String getKaizhi() {
        return kaizhi;
    }

    public puke setKaizhi(String kaizhi) {
        this.kaizhi = kaizhi;
        return this;
    }

    public String getYinshua() {
        return yinshua;
    }

    public puke setYinshua(String yinshua) {
        this.yinshua = yinshua;
        return this;
    }

    public String getDealoutSide() {
        return dealoutSide;
    }

    public puke setDealoutSide(String dealoutSide) {
        this.dealoutSide = dealoutSide;
        return this;
    }

    public String getPihe() {
        return pihe;
    }

    public puke setPihe(String pihe) {
        this.pihe = pihe;
        return this;
    }

    public String getNianhe() {
        return nianhe;
    }

    public puke setNianhe(String nianhe) {
        this.nianhe = nianhe;
        return this;
    }
}
