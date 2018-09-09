package com.wj.pms.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wj.pms.bean.PermissionBean;
import com.wj.pms.bean.UserBean;
import com.wj.pms.common.DateUtil;
import com.wj.pms.common.enums.BusinessResponseCodeEnum;
import com.wj.pms.common.enums.OrderIdTypeEnum;
import com.wj.pms.common.exception.BaseException;
import com.wj.pms.common.exception.BusinessException;
import com.wj.pms.common.exception.ViewException;
import com.wj.pms.mybatis.entity.*;
import com.wj.pms.mybatis.mapper.self.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-8-12 上午7:49
 */
@Service
public class PmsService extends BaseService {

    public List<String> getPermitState(User user) {
        List<Permission> userPermissions = pmsDao.getUserPermissions(user);
        List<String> a = userPermissions.stream().map(Permission::getContent).collect(Collectors.toList());
        return getPermitStateBean(a);
    }

    public List<Orders> getOrders4User(String list) {
        return pmsDao.getOrders4User(list);
    }

    private List<String> getPermitStateBean(List<String> userPermissions) {
        List<String> permissionBeans = new ArrayList<>();
        for (String perStr : userPermissions) {
            PermissionBean permissionBean = new PermissionBean();
            permissionBean.setRouters(new ArrayList<>());
            JSONObject parse1 = (JSONObject) JSONObject.parse(perStr);
            JSONArray routerArray = (JSONArray) parse1.get("router");
            Iterator<Object> iterator = routerArray.iterator();
            while (iterator.hasNext()) {
                String next = (String) iterator.next();
                permissionBeans.add(next);
            }
        }
        return permissionBeans;
    }

    public Orders insertOrUpdate(Orders orders) throws BaseException {
        if (Objects.isNull(orders.getId())) {
            List<Orders> list = ordersMapper.selectAll().stream()
                    .filter(orders1 -> orders1.getContractNo().equals(orders.getContractNo()))
                    .collect(Collectors.toList());
            if (list == null || list.size() > 0) {
                throw new ViewException(BusinessResponseCodeEnum.ORDERS_HAS_EXISTED, orders);
            }
            orders.setState("01");
            orders.setId(generateID(null, null));
            ordersMapper.insert(orders);
        } else {
            ordersMapper.updateByPrimaryKey(orders);
        }
        return ordersMapper.selectByPrimaryKey(orders.getId());
    }

    public OrderOperateInfo startOperate(String orderId, OrderOperateInfo orderOperateInfo) {
        RouterInfo routerInfoa = routerInfoMapper.selectAll().stream().filter(routerInfo -> orderOperateInfo.getActionCode().equals(routerInfo.getCode())).collect(Collectors.toList()).get(0);
        orderOperateInfo.setState("start");
        orderOperateInfo.setId(generateID(null, null));
        int insert = orderOperateInfoMapper.insert(orderOperateInfo);
        Orders orders = ordersMapper.selectByPrimaryKey(orderId);
        if(orders != null){
            orders.setState(routerInfoa.getNextCode());
            ordersMapper.updateByPrimaryKey(orders);
        }
        BoxOrder boxOrder = boxOrderMapper.selectByPrimaryKey(orderId);
        if(boxOrder != null){
            boxOrder.setState(routerInfoa.getNextCode());
            boxOrderMapper.updateByPrimaryKey(boxOrder);
        }
        CardOrder cardOrder = cardOrderMapper.selectByPrimaryKey(orderId);
        if(cardOrder != null){
            cardOrder.setState(routerInfoa.getNextCode());
            cardOrderMapper.updateByPrimaryKey(cardOrder);
        }
        return orderOperateInfo;
    }

    public void endOperate(String orderId, String orderOperateInfoId) {
        OrderOperateInfo orderOperateInfo = orderOperateInfoMapper.selectByPrimaryKey(orderOperateInfoId);
        orderOperateInfo.setState("end");
        orderOperateInfo.setId(generateID(null, null));
        orderOperateInfoMapper.insert(orderOperateInfo);

        Orders orders1 = ordersMapper.selectByPrimaryKey(orderId);
        RouterInfo routerInfoa = routerInfoMapper.selectAll().stream()
                .filter(routerInfo -> orders1.getState().equals(routerInfo.getCode()))
                .collect(Collectors.toList()).get(0);

        Orders orders = ordersMapper.selectByPrimaryKey(orderId);
        if(orders != null){
            orders.setState(routerInfoa.getNextCode());
            ordersMapper.updateByPrimaryKey(orders);
        }
        BoxOrder boxOrder = boxOrderMapper.selectByPrimaryKey(orderId);
        if(boxOrder != null){
            boxOrder.setState(routerInfoa.getNextCode());
            boxOrderMapper.updateByPrimaryKey(boxOrder);
        }
        CardOrder cardOrder = cardOrderMapper.selectByPrimaryKey(orderId);
        if(cardOrder != null){
            cardOrder.setState(routerInfoa.getNextCode());
            cardOrderMapper.updateByPrimaryKey(cardOrder);
        }
    }

    public List<OrderOperateInfo> getOrderHistory(String orderId) {
        return pmsDao.getOrderHistoryByOrderId(orderId);
    }

    public CardOrder insertOrUpdatePuke(CardOrder cardOrder) throws BusinessException {
        if (Objects.isNull(cardOrder.getId())) {
            List<CardOrder> list = cardOrderMapper.selectAll().stream()
                    .filter(cardOrder1 -> cardOrder.getCode().equals(cardOrder1.getCode()))
                    .collect(Collectors.toList());

            if (list == null || list.size() > 0) {
                throw new BusinessException(BusinessResponseCodeEnum.ORDERS_HAS_EXISTED, cardOrder);
            }
            cardOrder.setId(generateID(null, null));
            cardOrderMapper.insert(cardOrder);
        } else {
            cardOrderMapper.updateByPrimaryKey(cardOrder);
        }
        return cardOrderMapper.selectByPrimaryKey(cardOrder.getId());
    }

    public BoxOrder insertOrUpdateBox(BoxOrder boxOrder) throws BusinessException {
        if (Objects.isNull(boxOrder.getId())) {
            List<BoxOrder> collect = boxOrderMapper.selectAll().stream().filter(boxOrder1 -> boxOrder.getBoxOrderCode().equals(boxOrder1.getBoxOrderCode())).collect(Collectors.toList());

            if (collect != null && collect.size() > 0) {
                throw new BusinessException(BusinessResponseCodeEnum.ORDERS_HAS_EXISTED, boxOrder);
            }
            boxOrder.setId(generateID(null, null));
            boxOrderMapper.insert(boxOrder);
        } else {
            boxOrderMapper.updateByPrimaryKey(boxOrder);
        }
        return boxOrderMapper.selectByPrimaryKey(boxOrder.getId());
    }

    public Object moreOperation(String orderId, HttpSession session) {
        String orderState = pmsDao.selectOrderState(orderId);
        if (orderState.length() == 3) {
            Map<String, Object> map = new HashMap<>();
            BaseDirectory orderOperateInfo = pmsDao.getOrderStateNextOperationName(orderId);
            UserBean user = (UserBean) session.getAttribute("user");
//            List<String> userCodes = pmsDao.getOperationPermitUser(orderOperateInfo.getState());
            map.put("actionName", orderOperateInfo.getName());
            map.put("actionCode", orderOperateInfo.getCode());
            map.put("department", user.getDepartment().getDepartmentName());
            map.put("user2Permit", user.getUser().getDisplayName());
            return map;
        }
        if (orderState.length() == 4) {
            return orderOperateInfoMapper.selectAll().stream()
                    .filter(orderOperateInfo -> orderOperateInfo.getOrderid().equals(orderId)
                            && orderOperateInfo.getState().equals(orderState))
                    .collect(Collectors.toList()).get(0);
        }
        return null;
    }

    public UserBean getUserBean(User enUser) {
        Department department = pmsDao.selectDepartment(enUser.getCode());
        List<Role> roles = pmsDao.selectRoles(enUser.getCode());
        List<Permission> permissions = pmsDao.getUserPermissions(enUser);
        Map<String, Object> map = new HashMap<>();
        // TODO permissions ---> map
        UserBean userBean = new UserBean(enUser, department, roles, map);
        return userBean;
    }

    public String generateID(OrderIdTypeEnum type, String parentID) {
        String id = DateUtil.formatLocalDateTimeToString(LocalDateTime.now(), DateUtil.TIME_PATTERN_MILLISECOND1);
        String a = UUID.randomUUID().toString();
        if(StringUtils.isEmpty(parentID))
            return id + a.substring(a.length() - 5, a.length());
        else{
            assert id != null;
            return id + type.getValue() + a.substring(a.length() - 3, a.length());
        }
    }

}
