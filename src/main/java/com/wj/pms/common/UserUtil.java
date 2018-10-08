package com.wj.pms.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wj.pms.bean.UserBean;
import com.wj.pms.mybatis.entity.PermissionInfo;

import java.util.ArrayList;
import java.util.List;

public class UserUtil {
    /**
     * 在Session的userBean中获取订单状态字符串列表
     * @param userBean
     * @return
     */
    public static List<String> getUserAllowStates(UserBean userBean) {
        List<PermissionInfo> permissions = userBean.getPermissions();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < permissions.size(); i++){
            PermissionInfo info = permissions.get(i);
            String content = info.getContent();
            JSONObject parse = (JSONObject) JSONObject.parse(content);
            JSONArray permitStates = (JSONArray) parse.get("permitStates");
            List<String> strings = permitStates.toJavaList(String.class);
            list.addAll(strings);
        }
        // TODO 后续List去重
        return list;
    }
}
