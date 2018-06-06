package com.wj.bean;

/**
 * Describe: 纸盒
 *
 * @author YoungSmith
 * 18-6-4 下午10:56
 */
public class Hezi {
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
     * 开牌
     */
    private String kaipai;
    /**
     * 冲牌
     */
    private String chongpai;

    public Integer getId() {
        return id;
    }

    public Hezi setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Hezi setName(String name) {
        this.name = name;
        return this;
    }

    public BaseOrder getBaseOrder() {
        return baseOrder;
    }

    public Hezi setBaseOrder(BaseOrder baseOrder) {
        this.baseOrder = baseOrder;
        return this;
    }

    public String getBanfang() {
        return banfang;
    }

    public Hezi setBanfang(String banfang) {
        this.banfang = banfang;
        return this;
    }

    public String getKaizhi() {
        return kaizhi;
    }

    public Hezi setKaizhi(String kaizhi) {
        this.kaizhi = kaizhi;
        return this;
    }

    public String getYinshua() {
        return yinshua;
    }

    public Hezi setYinshua(String yinshua) {
        this.yinshua = yinshua;
        return this;
    }

    public String getDealoutSide() {
        return dealoutSide;
    }

    public Hezi setDealoutSide(String dealoutSide) {
        this.dealoutSide = dealoutSide;
        return this;
    }

    public String getKaipai() {
        return kaipai;
    }

    public Hezi setKaipai(String kaipai) {
        this.kaipai = kaipai;
        return this;
    }

    public String getChongpai() {
        return chongpai;
    }

    public Hezi setChongpai(String chongpai) {
        this.chongpai = chongpai;
        return this;
    }
}
