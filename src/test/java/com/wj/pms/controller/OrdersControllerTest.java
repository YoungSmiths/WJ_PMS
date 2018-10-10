package com.wj.pms.controller;

import com.alibaba.fastjson.JSONObject;
import com.wj.pms.common.util.HttpClientUtil;
import com.wj.pms.common.RequestMap;

public class OrdersControllerTest {

    private static final String host = "http://localhost:9000";
    public static void main(String[] args){
        String order;
        // 业务员操作
        order = testBusi();
        // 设计师操作
        testDesign(order);
        //
        String id = HttpClientUtil.delete2Str(host + "/api/orders/" + order);
        System.out.println("删除订单ID：" + id);
    }

    private static void testDesign(String orderId) {
        login("meisimeng", "123456");
        String moreOperationUrl = host + "/api/orders/" + orderId + "/moreOperationParentOrder";
        String insertOrdersRet = HttpClientUtil.get2Str(moreOperationUrl);
        System.out.println("更多操作：" + insertOrdersRet);

        JSONObject object = JSONObject.parseObject(insertOrdersRet);
        JSONObject data = (JSONObject) object.get("data");

        String startOperationUrl = host + "/api/orders/" + orderId + "/start";
        RequestMap map = new RequestMap().put("actionCode", data.get("actionCode")).put("actionName", data.get("actionName"));
        String ret = HttpClientUtil.postJson(startOperationUrl,map.toJson());
        System.out.println("开始操作：" + ret);
        JSONObject retObject = JSONObject.parseObject(ret);
        JSONObject data1 = (JSONObject) retObject.get("data");

        String endOperationUrl = host + "/api/orders/" + orderId + "/end?orderOperateInfoId=" + data1.get("id");
        String endRet = HttpClientUtil.get2Str(endOperationUrl);
        System.out.println("结束操作：" + endRet);

    }

    private static String testBusi() {
        login("shiyang", "123456");

        // 获取订单
        String ordersRet = HttpClientUtil.get2Str(host + "/api/orders");
        System.out.println("获取订单： " + ordersRet);
        RequestMap insertOrders = new RequestMap().put("orderName", "望京的订单")
                .put("orderCode", "NO_000000000000002").put("contractNo", "ContactNo_000000003")
                .put("count", "10000").put("papertype", null).put("width", "11").put("lengths", "11")
                .put("printRequire", "11").put("outSideHander", null).put("packageRequire", null)
                .put("parts", null).put("designPicPath", null).put("subOrderInfo", null)
                .put("describeInfo", null).put("status", "0");
        String insertOrdersRet = HttpClientUtil.postJson(host + "/api/orders", insertOrders.toJson());
        System.out.println("插入订单： " + insertOrdersRet);

        JSONObject data = (JSONObject) JSONObject.parseObject(insertOrdersRet).get("data");
        data.put("orderName","修改过的望京的订单");
        String updateOrdersRet = HttpClientUtil.postJson(host + "/api/orders", data.toJSONString());
        System.out.println("修改订单： " + updateOrdersRet);

        return (String) data.get("id");
//
    }

    private static void login(String name, String pass) {
        // 登录
        String loginUrl = host + "/api/user/login";
        RequestMap map = new RequestMap().put("code", name).put("password", pass);
        String loginRet = HttpClientUtil.postJson(loginUrl, map.toJson());
        System.out.println("登录： " + loginRet);
    }

    public static void post(String url){
        HttpClientUtil.postJson("/api/user/login", "");
    }
}