package com.wj.pms.controller;

import com.wj.pms.common.Result;
import com.wj.pms.mybatis.entity.Orders;
import com.wj.pms.mybatis.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseBody
    public Result insertOrUpdate(@RequestParam Orders orders) {
        if(Objects.isNull(orders.getId())){
            ordersMapper.insert(orders);
        }else{
            ordersMapper.updateByPrimaryKey(orders);
        }
        return Result.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Result delete(@PathVariable Integer id){
        if(Objects.nonNull(ordersMapper.selectByPrimaryKey(id)))
            ordersMapper.deleteByPrimaryKey(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Result select(@PathVariable Integer id){
        return Result.success(ordersMapper.selectByPrimaryKey(id));
    }

    @GetMapping
    @ResponseBody
    public Result selectAll(){
        return Result.success(ordersMapper.selectAll());
    }
}