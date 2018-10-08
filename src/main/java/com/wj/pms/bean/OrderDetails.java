package com.wj.pms.bean;

import com.wj.pms.mybatis.entity.BoxOrdersInfo;
import com.wj.pms.mybatis.entity.CardOrdersInfo;
import com.wj.pms.mybatis.entity.OrderInfo;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetails {

    // 基本信息
    private BigDecimal orderId; // 订单ID
    private String customer; // 客户联系人
    private Date orderStartDate; // 下单日期
    private String edition; // 班次
    private String productName; // 货品名称
    private Date deadLine; // 交货日期
    public OrderInfo getOrderInfo() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(orderId);
        orderInfo.setCustomer(customer);
        orderInfo.setOrderStartDate(orderStartDate);
        orderInfo.setEdition(edition);
        orderInfo.setProductName(productName);
        orderInfo.setDeadLine(deadLine);
        return orderInfo;
    }
    // 卡牌正面
    private BigDecimal zId;
    private String zVersionHouse; // 版房
    private String zOpenPaper; // 开纸
    private String zPrint; // 印刷
    private String zOutSideHandler; // 表面处理
    private String zOpenCard; // 开牌
    private String zBluntCard; // 冲牌
    public CardOrdersInfo getZCardOrdersInfo(){
        CardOrdersInfo cardOrdersInfo = new CardOrdersInfo();
        cardOrdersInfo.setId(zId);
        cardOrdersInfo.setVersionHouse(zVersionHouse);
        cardOrdersInfo.setOpenPaper(zOpenPaper);
        cardOrdersInfo.setPrint(zPrint);
        cardOrdersInfo.setOutSideHander(zOutSideHandler);
        cardOrdersInfo.setOpenCard(zOpenCard);
        cardOrdersInfo.setBluntCard(zBluntCard);
        return cardOrdersInfo;
    }
    // 卡牌反面
    private String fVersionHouse; // 版房
    private String fOpenPaper; // 开纸
    private String fPrint; // 印刷
    private String fOutSideHandler; // 表面处理
    private String fOpenCard; // 开牌
    private String fBluntCard; // 冲牌
    public CardOrdersInfo getFCardOrdersInfo(){
        CardOrdersInfo cardOrdersInfo = new CardOrdersInfo();
        cardOrdersInfo.setId(zId);
        cardOrdersInfo.setVersionHouse(fVersionHouse);
        cardOrdersInfo.setOpenPaper(fOpenPaper);
        cardOrdersInfo.setPrint(fPrint);
        cardOrdersInfo.setOutSideHander(fOutSideHandler);
        cardOrdersInfo.setOpenCard(fOpenCard);
        cardOrdersInfo.setBluntCard(fBluntCard);
        return cardOrdersInfo;
    }
    // 彩盒
    private BigDecimal hId;
    private String hVersionHouse; // 版房
    private String hOpenPaper; // 开纸
    private String hPrint; // 印刷
    private String hOutSideHandler; // 表面处理
    private String hBoxBeer; // 啤盒
    private String hBoxSticky; // 粘盒

    public BoxOrdersInfo getBoxOrdersInfo(){
        BoxOrdersInfo boxOrdersInfo = new BoxOrdersInfo();
        boxOrdersInfo.setId(hId);
        boxOrdersInfo.setVersionHouse(hVersionHouse);
        boxOrdersInfo.setOpenPaper(hOpenPaper);
        boxOrdersInfo.setPrint(hPrint);
        boxOrdersInfo.setOutSideHander(hOutSideHandler);
        boxOrdersInfo.setBoxBeer(hBoxBeer);
        boxOrdersInfo.setBoxSticky(hBoxSticky);
        return boxOrdersInfo;
    }

    public OrderDetails() {
    }

    public OrderDetails(BigDecimal orderId, String customer, Date orderStartDate, String edition, String productName, Date deadLine, BigDecimal zId, String zVersionHouse, String zOpenPaper, String zPrint, String zOutSideHandler, String zOpenCard, String zBluntCard, String fVersionHouse, String fOpenPaper, String fPrint, String fOutSideHandler, String fOpenCard, String fBluntCard, BigDecimal hId, String hVersionHouse, String hOpenPaper, String hPrint, String hOutSideHandler, String hBoxBeer, String hBoxSticky) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderStartDate = orderStartDate;
        this.edition = edition;
        this.productName = productName;
        this.deadLine = deadLine;
        this.zId = zId;
        this.zVersionHouse = zVersionHouse;
        this.zOpenPaper = zOpenPaper;
        this.zPrint = zPrint;
        this.zOutSideHandler = zOutSideHandler;
        this.zOpenCard = zOpenCard;
        this.zBluntCard = zBluntCard;
        this.fVersionHouse = fVersionHouse;
        this.fOpenPaper = fOpenPaper;
        this.fPrint = fPrint;
        this.fOutSideHandler = fOutSideHandler;
        this.fOpenCard = fOpenCard;
        this.fBluntCard = fBluntCard;
        this.hId = hId;
        this.hVersionHouse = hVersionHouse;
        this.hOpenPaper = hOpenPaper;
        this.hPrint = hPrint;
        this.hOutSideHandler = hOutSideHandler;
        this.hBoxBeer = hBoxBeer;
        this.hBoxSticky = hBoxSticky;
    }

    public BigDecimal getOrderId() {
        return orderId;
    }

    public OrderDetails setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public OrderDetails setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public Date getOrderStartDate() {
        return orderStartDate;
    }

    public OrderDetails setOrderStartDate(Date orderStartDate) {
        this.orderStartDate = orderStartDate;
        return this;
    }

    public String getEdition() {
        return edition;
    }

    public OrderDetails setEdition(String edition) {
        this.edition = edition;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public OrderDetails setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public OrderDetails setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
        return this;
    }

    public BigDecimal getzId() {
        return zId;
    }

    public OrderDetails setzId(BigDecimal zId) {
        this.zId = zId;
        return this;
    }

    public String getzVersionHouse() {
        return zVersionHouse;
    }

    public OrderDetails setzVersionHouse(String zVersionHouse) {
        this.zVersionHouse = zVersionHouse;
        return this;
    }

    public String getzOpenPaper() {
        return zOpenPaper;
    }

    public OrderDetails setzOpenPaper(String zOpenPaper) {
        this.zOpenPaper = zOpenPaper;
        return this;
    }

    public String getzPrint() {
        return zPrint;
    }

    public OrderDetails setzPrint(String zPrint) {
        this.zPrint = zPrint;
        return this;
    }

    public String getzOutSideHandler() {
        return zOutSideHandler;
    }

    public OrderDetails setzOutSideHandler(String zOutSideHandler) {
        this.zOutSideHandler = zOutSideHandler;
        return this;
    }

    public String getzOpenCard() {
        return zOpenCard;
    }

    public OrderDetails setzOpenCard(String zOpenCard) {
        this.zOpenCard = zOpenCard;
        return this;
    }

    public String getzBluntCard() {
        return zBluntCard;
    }

    public OrderDetails setzBluntCard(String zBluntCard) {
        this.zBluntCard = zBluntCard;
        return this;
    }

    public String getfVersionHouse() {
        return fVersionHouse;
    }

    public OrderDetails setfVersionHouse(String fVersionHouse) {
        this.fVersionHouse = fVersionHouse;
        return this;
    }

    public String getfOpenPaper() {
        return fOpenPaper;
    }

    public OrderDetails setfOpenPaper(String fOpenPaper) {
        this.fOpenPaper = fOpenPaper;
        return this;
    }

    public String getfPrint() {
        return fPrint;
    }

    public OrderDetails setfPrint(String fPrint) {
        this.fPrint = fPrint;
        return this;
    }

    public String getfOutSideHandler() {
        return fOutSideHandler;
    }

    public OrderDetails setfOutSideHandler(String fOutSideHandler) {
        this.fOutSideHandler = fOutSideHandler;
        return this;
    }

    public String getfOpenCard() {
        return fOpenCard;
    }

    public OrderDetails setfOpenCard(String fOpenCard) {
        this.fOpenCard = fOpenCard;
        return this;
    }

    public String getfBluntCard() {
        return fBluntCard;
    }

    public OrderDetails setfBluntCard(String fBluntCard) {
        this.fBluntCard = fBluntCard;
        return this;
    }

    public BigDecimal gethId() {
        return hId;
    }

    public OrderDetails sethId(BigDecimal hId) {
        this.hId = hId;
        return this;
    }

    public String gethVersionHouse() {
        return hVersionHouse;
    }

    public OrderDetails sethVersionHouse(String hVersionHouse) {
        this.hVersionHouse = hVersionHouse;
        return this;
    }

    public String gethOpenPaper() {
        return hOpenPaper;
    }

    public OrderDetails sethOpenPaper(String hOpenPaper) {
        this.hOpenPaper = hOpenPaper;
        return this;
    }

    public String gethPrint() {
        return hPrint;
    }

    public OrderDetails sethPrint(String hPrint) {
        this.hPrint = hPrint;
        return this;
    }

    public String gethOutSideHandler() {
        return hOutSideHandler;
    }

    public OrderDetails sethOutSideHandler(String hOutSideHandler) {
        this.hOutSideHandler = hOutSideHandler;
        return this;
    }

    public String gethBoxBeer() {
        return hBoxBeer;
    }

    public OrderDetails sethBoxBeer(String hBoxBeer) {
        this.hBoxBeer = hBoxBeer;
        return this;
    }

    public String gethBoxSticky() {
        return hBoxSticky;
    }

    public OrderDetails sethBoxSticky(String hBoxSticky) {
        this.hBoxSticky = hBoxSticky;
        return this;
    }
}
