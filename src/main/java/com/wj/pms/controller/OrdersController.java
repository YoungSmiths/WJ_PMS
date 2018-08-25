package com.wj.pms.controller;

import com.alibaba.fastjson.JSONObject;
import com.wj.pms.bean.PermissionBean;
import com.wj.pms.common.Result;
import com.wj.pms.mybatis.entity.Orders;
import com.wj.pms.mybatis.entity.User;
import com.wj.pms.mybatis.mapper.OrdersMapper;
import com.wj.pms.service.PmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-7-27 上午7:17
 */
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private PmsService pmsService;

    @PostMapping
    @ResponseBody
    public Result insertOrUpdate(@RequestBody Orders orders) {

        if(Objects.isNull(orders.getId())){
            ordersMapper.insert(orders);
        }else{
            ordersMapper.updateByPrimaryKey(orders);
        }
        return Result.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Result delete(@PathVariable String id){
        if(Objects.nonNull(ordersMapper.selectByPrimaryKey(id)))
            ordersMapper.deleteByPrimaryKey(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Result select(@PathVariable String id){
        return Result.success(ordersMapper.selectByPrimaryKey(id));
    }

    @GetMapping
    @ResponseBody
    public Result selectAll(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<String> permitStates = pmsService.getPermitState(user);
        List<Orders> list = new ArrayList<>();
        for(String a : permitStates){
            list.addAll(pmsService.getOrders4User(a));
        }
        return Result.success(list);
    }
}
