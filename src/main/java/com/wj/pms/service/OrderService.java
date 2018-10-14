package com.wj.pms.service;

import com.wj.pms.common.BeanUtil;
import com.wj.pms.common.enums.BusinessResponseCodeEnum;
import com.wj.pms.common.exception.BaseException;
import com.wj.pms.common.exception.BusinessException;
import com.wj.pms.common.exception.ViewException;
import com.wj.pms.common.util.PrimaryKeyUtil;
import com.wj.pms.mybatis.entity.BoxOrdersInfo;
import com.wj.pms.mybatis.entity.CardOrdersInfo;
import com.wj.pms.mybatis.entity.OrderInfo;
import com.wj.pms.mybatis.entity.OrdersRelation;
import com.wj.pms.mybatis.mapper.self.BaseService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service("orderService")
public class OrderService extends BaseService {
    public OrderInfo insertOrUpdate(OrderInfo orders) throws BaseException {
        if (Objects.isNull(orders.getId())) {
            orders.setStatus("01");
            List<OrderInfo> list = orderInfoMapper.selectAll();
            for (int i = 0; list != null && i < list.size(); i++) {
                if (list.get(i).getContractNo().equals(orders.getContractNo()))
                    throw new ViewException(BusinessResponseCodeEnum.ORDERS_HAS_EXISTED, orders);
            }
            orders.setId(PrimaryKeyUtil.generateID(null, null));
            orderInfoMapper.insert(orders);
        } else {
            OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(orders.getId());
            BeanUtil.copyProperties(orders, orderInfo);
            orderInfoMapper.updateByPrimaryKey(orderInfo);
        }
        return orderInfoMapper.selectByPrimaryKey(orders.getId());
    }

    public List<OrderInfo> getOrders4User(OrderInfo orderInfo) {
        return pmsDao.getOrders4User(orderInfo);
    }

    public CardOrdersInfo insertOrUpdatePuke(BigDecimal parentId, CardOrdersInfo cardOrder) throws BusinessException {
        if (Objects.isNull(cardOrder.getId()) && Objects.isNull(ordersRelationMapper.selectByPrimaryKey(parentId))) {
            BigDecimal pukeId = PrimaryKeyUtil.generateID(null, null);
            cardOrder.setId(pukeId);
            cardOrdersInfoMapper.insert(cardOrder);

            OrdersRelation ordersRelation = new OrdersRelation();
            ordersRelation.setId(PrimaryKeyUtil.generateID(null, null));
            ordersRelation.setParentId(parentId);
            ordersRelation.setOrderId(pukeId);
            ordersRelationMapper.insert(ordersRelation);
        } else {
            cardOrdersInfoMapper.updateByPrimaryKey(cardOrder);
        }
        return cardOrdersInfoMapper.selectByPrimaryKey(cardOrder.getId());
    }

    public BoxOrdersInfo insertOrUpdateBox(BigDecimal parentId, BoxOrdersInfo boxOrder) throws BusinessException {
        if (Objects.isNull(ordersRelationMapper.selectByPrimaryKey(parentId)) && Objects.isNull(boxOrder.getId())) {
            BigDecimal boxId = PrimaryKeyUtil.generateID(null, null);
            boxOrder.setId(boxId);
            boxOrdersInfoMapper.insert(boxOrder);
            System.out.print("");
            OrdersRelation ordersRelation = new OrdersRelation();
            ordersRelation.setId(PrimaryKeyUtil.generateID(null, null));
            ordersRelation.setParentId(parentId);
            ordersRelation.setOrderId(boxId);
            ordersRelationMapper.insert(ordersRelation);
        } else {
            boxOrdersInfoMapper.updateByPrimaryKey(boxOrder);
        }
        return boxOrdersInfoMapper.selectByPrimaryKey(boxOrder.getId());
    }

}
