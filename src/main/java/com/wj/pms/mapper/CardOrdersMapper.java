package com.wj.pms.mapper;

import com.wj.pms.model.CardOrders;
import com.wj.pms.model.CardOrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardOrdersMapper {
    int countByExample(CardOrdersExample example);

    int deleteByExample(CardOrdersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardOrders record);

    int insertSelective(CardOrders record);

    List<CardOrders> selectByExample(CardOrdersExample example);

    CardOrders selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardOrders record, @Param("example") CardOrdersExample example);

    int updateByExample(@Param("record") CardOrders record, @Param("example") CardOrdersExample example);

    int updateByPrimaryKeySelective(CardOrders record);

    int updateByPrimaryKey(CardOrders record);
}