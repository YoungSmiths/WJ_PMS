package com.wj.pms.controller;

import com.wj.pms.bean.OrderDetails;
import com.wj.pms.bean.UserBean;
import com.wj.pms.common.BaseController;
import com.wj.pms.common.BeanUtil;
import com.wj.pms.common.Result;
import com.wj.pms.common.UserUtil;
import com.wj.pms.common.exception.BaseException;
import com.wj.pms.common.exception.BusinessException;
import com.wj.pms.mybatis.entity.BoxOrdersInfo;
import com.wj.pms.mybatis.entity.CardOrdersInfo;
import com.wj.pms.mybatis.entity.OrderInfo;
import com.wj.pms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
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
public class OrdersController extends BaseController {

    @Autowired
    private OrderService orderService;

    /**
     * 插入订单基本信息
     * @param baseOrderInfo
     * @return
     * @throws BaseException
     */
    @PostMapping("insertOrUpdateBaseOrder")
    @ResponseBody
    public Result insertOrUpdate(@RequestBody OrderInfo baseOrderInfo) throws BaseException {
        OrderInfo info = new OrderInfo();
        BeanUtil.copyProperties(baseOrderInfo, info);
        com.wj.pms.mybatis.entity.OrderInfo ret = orderService.insertOrUpdate(info);
        return Result.success(ret);
    }

    /**
     *  查询父订单信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ResponseBody
    public Result select(@PathVariable BigDecimal id){
        return Result.success(orderInfoMapper.selectByPrimaryKey(id));
    }

    /**
     * 查询用户所有权下父订单信息列表
     * @param orderInfo
     * @param session
     * @return
     */
    @GetMapping
    @ResponseBody
    public Result selectAll(@RequestBody OrderInfo orderInfo, HttpSession session){
        UserBean user = (UserBean) session.getAttribute("user");
        List<String> permitStates = UserUtil.getUserAllowStates(user);
        // todo 后续优化代码
        List<OrderInfo> list = new ArrayList<>();
        for(String a : permitStates){
            if(a.equals(orderInfo.getStatus()))
                list.addAll(orderService.getOrders4User(orderInfo));
        }
        return Result.success(list);
    }

    @PostMapping("/{parentId}/orderDetails")
    @ResponseBody
    public Result insertOrderDetail(@PathVariable String parentId, @RequestBody OrderDetails orderDetails) throws BusinessException {
        OrderInfo orderInfo = orderDetails.getOrderInfo();
        BoxOrdersInfo boxOrdersInfo = orderDetails.getBoxOrdersInfo();
        CardOrdersInfo fCardOrdersInfo = orderDetails.getFCardOrdersInfo();
        CardOrdersInfo zCardOrdersInfo = orderDetails.getZCardOrdersInfo();
        OrderInfo orderInfo1 = orderService.insertOrUpdate(orderInfo);
        orderService.insertOrUpdateBox(orderInfo1.getId(), boxOrdersInfo);
        orderService.insertOrUpdatePuke(orderInfo1.getId(), fCardOrdersInfo);
        orderService.insertOrUpdatePuke(orderInfo1.getId(), zCardOrdersInfo);
        return Result.success();
    }

}