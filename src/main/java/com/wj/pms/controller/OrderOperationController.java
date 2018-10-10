package com.wj.pms.controller;

import com.wj.pms.common.Result;
import com.wj.pms.mybatis.entity.OrderOperateRecordInfo;
import com.wj.pms.service.OrderOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
@RequestMapping("api/operation")
public class OrderOperationController {

    @Autowired
    private OrderOperationService orderOperationService;

    @GetMapping("/{orderId}/moreOperation")
    @ResponseBody
    public Result moreOperationParentOrder(@PathVariable BigDecimal orderId, HttpSession session){
        return Result.success(orderOperationService.moreOperationParentOrder(orderId, session));
    }

    @GetMapping("/{orderId}/moreOperation/{childId}")
    @ResponseBody
    public Result moreOperationChildOrder(@PathVariable BigDecimal orderId,@PathVariable BigDecimal childId, HttpSession session){
        return Result.success(orderOperationService.moreOperationChildrenOrder(orderId, childId, session));
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
    public Result startOperate(@PathVariable BigDecimal orderId, @RequestBody OrderOperateRecordInfo orderOperateInfo){
        return Result.success(orderOperationService.startOperate(orderId, orderOperateInfo));
    }

    /**
     *
     * @param orderId
     * @param orderOperateInfoId
     * @return
     */
    @GetMapping("/{orderId}/end")
    @ResponseBody
    public Result endOperate(@PathVariable BigDecimal orderId, @RequestParam BigDecimal orderOperateInfoId){
        orderOperationService.endOperate(orderId, orderOperateInfoId);
        return Result.success();
    }
}
