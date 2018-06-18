package com.wj.pms.mapper;

import com.wj.pms.model.BaseOrders;
import com.wj.pms.model.BaseOrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseOrdersMapper {
    int countByExample(BaseOrdersExample example);

    int deleteByExample(BaseOrdersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseOrders record);

    int insertSelective(BaseOrders record);

    List<BaseOrders> selectByExample(BaseOrdersExample example);

    BaseOrders selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseOrders record, @Param("example") BaseOrdersExample example);

    int updateByExample(@Param("record") BaseOrders record, @Param("example") BaseOrdersExample example);

    int updateByPrimaryKeySelective(BaseOrders record);

    int updateByPrimaryKey(BaseOrders record);
}