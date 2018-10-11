package com.wj.pms.mybatis.mapper.self;

import com.wj.pms.mybatis.entity.OrderOperateRecordInfo;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

public interface OrderOperationRecordInfoMapperExt {

    @Select("select * from order_operate_record_info a where a.order_id = #{orderId, jdbcType=VARCHAR} order by a.update_time desc")
    List<OrderOperateRecordInfo> selectByOrderId(BigDecimal orderId);
}
