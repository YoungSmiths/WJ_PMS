package com.wj.pms.mybatis.mapper.self;

import com.wj.pms.mybatis.entity.*;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.util.List;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-7-31 上午7:24
 */
public interface PmsDao {

    @Select("SELECT * FROM order_info o WHERE o.state = #{state, jdbcType=VARCHAR} and o.order_name = #{orderName, jdbcType=VARCHAR}")
    List<OrderInfo> getOrders4User(OrderInfo orderInfo);

}
