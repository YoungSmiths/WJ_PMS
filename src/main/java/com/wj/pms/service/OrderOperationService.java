package com.wj.pms.service;

import com.wj.pms.bean.UserBean;
import com.wj.pms.common.util.PrimaryKeyUtil;
import com.wj.pms.mybatis.entity.*;
import com.wj.pms.mybatis.mapper.self.BaseService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderOperationService extends BaseService {

    public Object moreOperationParentOrder(BigDecimal orderId, HttpSession session) {

        OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(orderId);
        String status = orderInfo.getStatus();
        List<BaseDirectoryInfo> operationCode = getOperationCode(status);
//
//
//
//        String statusFlag = status.substring(2,4);
//        if ("".equals(statusFlag)) {
//            return orderOperateRecordInfoMapper.selectAll().stream()
//                    .filter(orderOperateInfo -> orderOperateInfo.getId().equals(orderId)
//                            && orderOperateInfo.getActionCode().equals(orderState))
//                    .collect(Collectors.toList()).get(0);
//        }
////        if (orderState.length() == 3) {
//        Map<String, Object> map = new HashMap<>();
//        BaseDirectoryInfo orderOperateInfo = pmsDao.getOrderStateNextOperationName(orderId);
//        UserBean user = (UserBean) session.getAttribute("user");
////            List<String> userCodes = pmsDao.getOperationPermitUser(orderOperateInfo.getState());
//        map.put("actionName", orderOperateInfo.getName());
//        map.put("actionCode", orderOperateInfo.getCode());
//        map.put("department", user.getDepartment());
//        map.put("user2Permit", user.getUser().getDisplayName());
//        return map;
////        }
        return null;
    }

    /**
     *  *00一般出现在订单拆分时
     *  *03和**04状态的订单进入下一个操作
     *  *05状态的订单会返回到上一步操作
     *  @param status
     *  @return
     */
    private List<BaseDirectoryInfo> getOperationCode(String status){
        String currentOperation = status.substring(0,2);
        String statusFlag = status.substring(2,4);
        if("03".equals(statusFlag) || "04".equals(statusFlag)){
            List<String> collect = routerInfoMapper.selectAll().stream()
                    .filter(routerInfo -> routerInfo.getCode().equals(currentOperation))
                    .map(routerInfo -> routerInfo.getCode())
                    .collect(Collectors.toList());
            List<BaseDirectoryInfo> collect1 = baseDirectoryInfoMapper.selectAll().stream()
                    .filter(baseDirectoryInfo -> "OPERATION".equals(baseDirectoryInfo.getType()))
                    .filter(baseDirectoryInfo -> collect.contains(baseDirectoryInfo.getCode()))
                    .collect(Collectors.toList());
            return collect1;
        }
        if("05".equals(statusFlag)){
            List<String> collect = routerInfoMapper.selectAll().stream()
                    .filter(routerInfo -> routerInfo.getNextCode().equals(currentOperation))
                    .map(routerInfo -> routerInfo.getCode())
                    .collect(Collectors.toList());
            List<BaseDirectoryInfo> collect1 = baseDirectoryInfoMapper.selectAll().stream()
                    .filter(baseDirectoryInfo -> "OPERATION".equals(baseDirectoryInfo.getType()))
                    .filter(baseDirectoryInfo -> collect.contains(baseDirectoryInfo.getCode()))
                    .collect(Collectors.toList());
            return collect1;
        }
        return null;
    }

    public OrderOperateRecordInfo startOperate(BigDecimal orderId, OrderOperateRecordInfo orderOperateInfo) {
        RouterInfo routerInfoa = routerInfoMapper.selectAll().stream().filter(routerInfo -> orderOperateInfo.getActionCode().equals(routerInfo.getCode())).collect(Collectors.toList()).get(0);
        orderOperateInfo.setActionCode("start");
        orderOperateInfo.setActionName("开始操作");
        orderOperateInfo.setId(PrimaryKeyUtil.generateID(null, null));
        int insert = orderOperateRecordInfoMapper.insert(orderOperateInfo);
        OrderInfo orders = orderInfoMapper.selectByPrimaryKey(orderId);
        if(orders != null){
            orders.setStatus(routerInfoa.getNextCode());
            orderInfoMapper.updateByPrimaryKey(orders);
        }
        BoxOrdersInfo boxOrder = boxOrdersInfoMapper.selectByPrimaryKey(orderId);
        if(boxOrder != null){
            boxOrder.setStatus(routerInfoa.getNextCode());
            boxOrdersInfoMapper.updateByPrimaryKey(boxOrder);
        }
        CardOrdersInfo cardOrder = cardOrdersInfoMapper.selectByPrimaryKey(orderId);
        if(cardOrder != null){
            cardOrder.setStatus(routerInfoa.getNextCode());
            cardOrdersInfoMapper.updateByPrimaryKey(cardOrder);
        }
        return orderOperateInfo;
    }

    public void endOperate(BigDecimal orderId, BigDecimal orderOperateInfoId) {
        OrderOperateRecordInfo orderOperateInfo = orderOperateRecordInfoMapper.selectByPrimaryKey(orderOperateInfoId);
        orderOperateInfo.setActionCode("end");
        orderOperateInfo.setOrderId(orderId);
        orderOperateInfo.setId(PrimaryKeyUtil.generateID(null, null));
        orderOperateRecordInfoMapper.insert(orderOperateInfo);

        OrderInfo orders1 = orderInfoMapper.selectByPrimaryKey(orderId);
        RouterInfo routerInfoa = routerInfoMapper.selectAll().stream()
                .filter(routerInfo -> orders1.getStatus().equals(routerInfo.getCode()))
                .collect(Collectors.toList()).get(0);

        OrderInfo orders = orderInfoMapper.selectByPrimaryKey(orderId);
        if(orders != null){
            orders.setStatus(routerInfoa.getNextCode());
            orderInfoMapper.updateByPrimaryKey(orders);
        }
        BoxOrdersInfo boxOrder = boxOrdersInfoMapper.selectByPrimaryKey(orderId);
        if(boxOrder != null){
            boxOrder.setStatus(routerInfoa.getNextCode());
            boxOrdersInfoMapper.updateByPrimaryKey(boxOrder);
        }
        CardOrdersInfo cardOrder = cardOrdersInfoMapper.selectByPrimaryKey(orderId);
        if(cardOrder != null){
            cardOrder.setStatus(routerInfoa.getNextCode());
            cardOrdersInfoMapper.updateByPrimaryKey(cardOrder);
        }
    }

    public Object moreOperationChildrenOrder(BigDecimal orderId, BigDecimal childId, HttpSession session) {
    }
}
