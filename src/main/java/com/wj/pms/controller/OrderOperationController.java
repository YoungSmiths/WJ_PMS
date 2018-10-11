package com.wj.pms.controller;

import com.wj.pms.bean.OperationBean;
import com.wj.pms.common.Result;
import com.wj.pms.common.exception.BusinessException;
import com.wj.pms.mybatis.entity.BoxOrdersInfo;
import com.wj.pms.mybatis.entity.CardOrdersInfo;
import com.wj.pms.mybatis.entity.OrderInfo;
import com.wj.pms.mybatis.entity.OrderOperateRecordInfo;
import com.wj.pms.mybatis.mapper.BoxOrdersInfoMapper;
import com.wj.pms.mybatis.mapper.CardOrdersInfoMapper;
import com.wj.pms.mybatis.mapper.OrderInfoMapper;
import com.wj.pms.service.OrderOperationService;
import org.checkerframework.checker.units.qual.A;
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

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private BoxOrdersInfoMapper boxOrdersInfoMapper;

    @Autowired
    private CardOrdersInfoMapper cardOrdersInfoMapper;

    @GetMapping("/{orderId}/moreOperation")
    @ResponseBody
    public Result moreOperationParentOrder(@PathVariable BigDecimal orderId, HttpSession session){
        OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(orderId);
        String status = orderInfo.getStatus();
        return Result.success(orderOperationService.moreOperationOrder(orderId, status, session));
    }

    @GetMapping("/{orderId}/moreOperation/{childId}")
    @ResponseBody
    public Result moreOperationChildOrder(@PathVariable BigDecimal orderId,@PathVariable BigDecimal childId, HttpSession session){
        CardOrdersInfo cardOrdersInfo = cardOrdersInfoMapper.selectByPrimaryKey(childId);
        BoxOrdersInfo boxOrdersInfo = boxOrdersInfoMapper.selectByPrimaryKey(childId);
        String status;
        if(boxOrdersInfo != null){
            status = boxOrdersInfo.getStatus();
        } else if(cardOrdersInfo != null) {
            status = cardOrdersInfo.getStatus();
        } else {
            throw new BusinessException();
        }
        return Result.success(orderOperationService.moreOperationOrder(orderId, status, session));
    }

    /**
     *
     {
     "orderid":"2018081916485481851",
     "actionCode":"02",
     "actionName":"设计图纸",
     "updateBy":"",
     }
     * @param orderId
     * @param orderOperateRecordInfo
     * @return
     */
    @PostMapping("/{orderId}/operation")
    @ResponseBody
    public Result startParentOperate(@PathVariable BigDecimal orderId, @RequestBody OrderOperateRecordInfo orderOperateRecordInfo){
        orderOperateRecordInfo.setOrderId(orderId);
        return Result.success(orderOperationService.insertOrUpdateOrderOperateRecordInfo(orderOperateRecordInfo));
    }

}
