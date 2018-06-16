package com.wj.pms.common.mapper;

import com.wj.pms.common.model.BoxOrders;
import com.wj.pms.common.model.BoxOrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BoxOrdersMapper {
    int countByExample(BoxOrdersExample example);

    int deleteByExample(BoxOrdersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BoxOrders record);

    int insertSelective(BoxOrders record);

    List<BoxOrders> selectByExample(BoxOrdersExample example);

    BoxOrders selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BoxOrders record, @Param("example") BoxOrdersExample example);

    int updateByExample(@Param("record") BoxOrders record, @Param("example") BoxOrdersExample example);

    int updateByPrimaryKeySelective(BoxOrders record);

    int updateByPrimaryKey(BoxOrders record);
}