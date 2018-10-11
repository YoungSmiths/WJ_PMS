package com.wj.pms.service;

import com.wj.pms.bean.OperationBean;
import com.wj.pms.bean.UserBean;
import com.wj.pms.common.Constants;
import com.wj.pms.common.util.PrimaryKeyUtil;
import com.wj.pms.common.util.SessionUtil;
import com.wj.pms.mybatis.entity.*;
import com.wj.pms.mybatis.mapper.self.BaseService;
import com.wj.pms.mybatis.mapper.self.OrderOperationRecordInfoMapperExt;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderOperationService extends BaseService {

    @Autowired
    private OrderOperationRecordInfoMapperExt orderOperationRecordInfoMapperExt;
    public Map<String, Object> moreOperationOrder(BigDecimal orderId, String status, HttpSession session) {

        HashMap<String, Object> map = new HashMap<>();
        UserBean userBean = (UserBean) SessionUtil.getAttr(session, Constants.SESSION_USER_KEY);
        map.put("operatorName", userBean.getUser().getDisplayName());

        String currentOperation = status.substring(0, 2);
        String statusFlag = status.substring(2, 4);

        if ("01".equals(statusFlag) || "02".equals(statusFlag)) {
            List<OrderOperateRecordInfo> operateRecordInfos = orderOperationRecordInfoMapperExt.selectByOrderId(orderId);
            OrderOperateRecordInfo info = operateRecordInfos.get(0);
            map.put("actionCode", info.getActionCode());
            map.put("actionName", info.getActionName());
            map.put("orderId", info.getOrderId() + "");
            map.put("operatorName", info.getCreateBy());
            map.put("startTime", info.getCreateTime());
            return map;
        }

        if ("03".equals(statusFlag) || "04".equals(statusFlag)) {
            List<String> collect = routerInfoMapper.selectAll().stream()
                    .filter(routerInfo -> routerInfo.getCode().equals(currentOperation))
                    .map(routerInfo -> routerInfo.getCode())
                    .collect(Collectors.toList());
            List<BaseDirectoryInfo> collect1 = baseDirectoryInfoMapper.selectAll().stream()
                    .filter(baseDirectoryInfo -> "OPERATION".equals(baseDirectoryInfo.getType()))
                    .filter(baseDirectoryInfo -> collect.contains(baseDirectoryInfo.getCode()))
                    .collect(Collectors.toList());
            BaseDirectoryInfo baseDirectoryInfo = collect1.get(0);

            map.put("actionCode", baseDirectoryInfo.getCode());
            map.put("actionName", baseDirectoryInfo.getName());
            map.put("orderId", orderId);
            map.put("startTime", new Date());
            return map;
        }
        if ("05".equals(statusFlag)) {
            String code = routerInfoMapper.selectAll().stream().filter(routerInfo -> routerInfo.getCode().equals(status)) // 一个状态只对应一个操作
                    .findFirst().get().getCode();
            BaseDirectoryInfo baseDirectoryInfo1 = baseDirectoryInfoMapper.selectAll().stream().filter(baseDirectoryInfo -> "OPERATION".equals(baseDirectoryInfo.getType()))
                    .filter(baseDirectoryInfo -> code.equals(baseDirectoryInfo.getCode())).findFirst().get();
            map.put("actionCode", baseDirectoryInfo1.getCode());
            map.put("actionName", baseDirectoryInfo1.getName());
            map.put("orderId", orderId);
            map.put("startTime", new Date());
            return map;

//            List<BaseDirectoryInfo> collect1 = baseDirectoryInfoMapper.selectAll().stream()
//                    .filter(baseDirectoryInfo -> "OPERATION".equals(baseDirectoryInfo.getType()))
//                    .filter(baseDirectoryInfo -> collect.contains(baseDirectoryInfo.getCode()))
//                    .collect(Collectors.toList());
//            return collect1;
        }
        return null;

//        List<BaseDirectoryInfo> operationCode = getOperationCode(status);
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
    }

    /**
     * *00一般出现在订单拆分时
     * *03和**04状态的订单进入下一个操作
     * *05状态的订单会返回到上一步操作
     *
     * @param status
     * @return
     */
    private List<BaseDirectoryInfo> getOperationCode(String status) {
        String currentOperation = status.substring(0, 2);
        String statusFlag = status.substring(2, 4);
        if ("03".equals(statusFlag) || "04".equals(statusFlag)) {
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
        if ("05".equals(statusFlag)) {
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

    public OrderOperateRecordInfo insertOrUpdateOrderOperateRecordInfo(OrderOperateRecordInfo orderOperateRecordInfo) {
        orderOperateRecordInfo.setUpdateTime(new Date());
        if(orderOperateRecordInfo.getId() == null){
            orderOperateRecordInfo.setCreateBy(orderOperateRecordInfo.getUpdateBy());
            orderOperateRecordInfo.setCreateTime(orderOperateRecordInfo.getUpdateTime());
            orderOperateRecordInfoMapper.insert(orderOperateRecordInfo);
        } else {
            orderOperateRecordInfoMapper.updateByPrimaryKey(orderOperateRecordInfo);
        }
        return orderOperateRecordInfo;
    }

}
