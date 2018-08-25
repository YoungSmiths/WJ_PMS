package com.wj.pms.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wj.pms.bean.PermissionBean;
import com.wj.pms.mybatis.entity.Orders;
import com.wj.pms.mybatis.entity.User;
import com.wj.pms.mybatis.mapper.self.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-8-12 上午7:49
 */
@Service
public class PmsService extends BaseService{

    public List<String> getPermitState(User user){
        List<String> userPermissions = pmsDao.getUserPermissions(user);
        return getPermitStateBean(userPermissions);
    }

    public List<Orders> getOrders4User(String list){
        return pmsDao.getOrders4User(list);
    }

    private List<String> getPermitStateBean(List<String> userPermissions){
        List<String> permissionBeans = new ArrayList<>();
        for(String perStr : userPermissions){
            PermissionBean permissionBean = new PermissionBean();
            permissionBean.setRouters(new ArrayList<>());
            JSONObject parse1 = (JSONObject) JSONObject.parse(perStr);
            String routers = (String) parse1.get("router");
            permissionBeans.addAll(Arrays.asList(routers));
        }
        return permissionBeans;
    }
}
