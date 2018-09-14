package com.wj.pms.controller;

import com.wj.pms.bean.UserBean;
import com.wj.pms.common.Result;
import com.wj.pms.common.exception.BaseException;
import com.wj.pms.common.exception.BusinessException;
import com.wj.pms.mybatis.entity.*;
import com.wj.pms.mybatis.mapper.BoxOrderMapper;
import com.wj.pms.mybatis.mapper.CardOrderMapper;
import com.wj.pms.mybatis.mapper.OrdersMapper;
import com.wj.pms.service.PmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
public class OrdersController {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private BoxOrderMapper boxOrderMapper;

    @Autowired
    private CardOrderMapper cardOrderMapper;

    @Autowired
    private PmsService pmsService;

    @PostMapping
    @ResponseBody
    public Result insertOrUpdate(@RequestBody Orders orders) throws BaseException {
        return Result.success(pmsService.insertOrUpdate(orders));
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
        UserBean user = (UserBean) session.getAttribute("user");
        List<String> permitStates = pmsService.getPermitState(user.getUser());
        List<Orders> list = new ArrayList<>();
        for(String a : permitStates){
            list.addAll(pmsService.getOrders4User(a));
        }
        return Result.success(list);
    }

    @GetMapping("/{orderId}/moreOperation")
    @ResponseBody
    public Result moreOperation(@PathVariable String orderId, HttpSession session){
        return Result.success(pmsService.moreOperation(orderId, session));
    }

    /**
     *
     {
     "orderid":"2018081916485481851",
     "actionCode":"02",
     "actionName":"设计图纸"
     }
     * @param orderId
     * @param orderOperateInfo
     * @return
     */
    @PostMapping("/{orderId}/start")
    @ResponseBody
    public Result startOperate(@PathVariable String orderId, @RequestBody OrderOperateInfo orderOperateInfo){
        pmsService.startOperate(orderId, orderOperateInfo);
        return Result.success();
    }

    /**
     *
     * @param orderId
     * @param orderOperateInfoId
     * @return
     */
    @GetMapping("/{orderId}/end")
    @ResponseBody
    public Result endOperate(@PathVariable String orderId, @RequestParam String orderOperateInfoId){
        pmsService.endOperate(orderId, orderOperateInfoId);
        return Result.success();
    }

    @GetMapping("/{id}/history")
    @ResponseBody
    public Result getOrderHistory(@PathVariable String id){
        return Result.success(pmsService.getOrderHistory(id));
    }

    @PostMapping("/{parentId}/children/card")
    @ResponseBody
    public Result insertOrUpdatePuke(@PathVariable String parentId, @RequestBody CardOrder cardOrder) throws BusinessException {
        if(StringUtils.isEmpty(cardOrder.getParentOrderId()))
            cardOrder.setParentOrderId(parentId);
        return Result.success(pmsService.insertOrUpdatePuke(cardOrder));
    }

    @DeleteMapping("/{parentId}/children/card/{childId}")
    @ResponseBody
    public Result deleteCard(@PathVariable String parentId, @PathVariable String childId){
        cardOrderMapper.deleteByPrimaryKey(childId);
        return Result.success();
    }

    @PostMapping("/{parentId}/children/box")
    @ResponseBody
    public Result insertOrUpdateBox(@PathVariable String parentId, @RequestBody BoxOrder boxOrder) throws BusinessException {
        if(StringUtils.isEmpty(boxOrder.getParentOrderId()))
            boxOrder.setParentOrderId(parentId);
        return Result.success(pmsService.insertOrUpdateBox(boxOrder));
    }

    @DeleteMapping("/{parentId}/children/box/{childId}")
    @ResponseBody
    public Result deleteBox(@PathVariable String parentId, @PathVariable String childId){
        boxOrderMapper.deleteByPrimaryKey(childId);
        return Result.success();
    }

}