package com.wj.pms.controller;


import com.alibaba.fastjson.JSONObject;
import com.wj.pms.common.HttpClientUtil;
import com.wj.pms.common.RequestMap;

public class OrdersControllerTest {

    private static final String host = "http://localhost:9000";
    public static void main(String[] args){
        // 登录
        String loginUrl = host + "/api/user/login";
        RequestMap map = new RequestMap().put("code", "shiyang").put("password", "123456");
        String loginRet = HttpClientUtil.postJson(loginUrl, map.toJson());
        System.out.println("登录： " + loginRet);

        // 获取订单
        String getOrdersurl = host + "/api/orders";
        String ordersRet = HttpClientUtil.get2Str(getOrdersurl);
        System.out.println("获取订单： " + ordersRet);

        String insertOrdersurl = host + "/api/orders";
        RequestMap insertOrders = new RequestMap().put("orderName", "望京的订单")
                .put("orderCode", "NO_000000000000002").put("contractNo", "ContactNo_000000003")
                .put("count", "10000").put("papertype", null).put("width", "11").put("lengths", "11")
                .put("printRequire", "11").put("outSideHander", null).put("packageRequire", null)
                .put("parts", null).put("designPicPath", null).put("subOrderInfo", null)
                .put("describeInfo", null).put("status", "0");
        String insertOrdersRet = HttpClientUtil.postJson(insertOrdersurl, insertOrders.toJson());
        System.out.println("插入订单： " + insertOrdersRet);

        JSONObject data = (JSONObject) JSONObject.parseObject(insertOrdersRet).get("data");
        data.put("orderName","修改过的望京的订单");
        String updateOrdersRet = HttpClientUtil.postJson(insertOrdersurl, data.toJSONString());
        System.out.println("修改订单： " + updateOrdersRet);

        String id = HttpClientUtil.delete2Str(insertOrdersurl + "/" + data.get("id"));
        System.out.println("删除订单ID：" + id);
    }

    public static void post(String url){
        HttpClientUtil.postJson("/api/user/login", "");
    }
}