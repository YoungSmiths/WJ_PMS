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

    /**
     * 获取订单的状态，可能是父订单，也可能是子订单，并关联baseDirectory
     * @param orderId
     * @return 下一个操作的名字
     */
    @Select("select bd.code, bd.name from router_info ri\n" +
            "  left join\n" +
            "  base_directory_info bd on ri.next_code = bd.code and bd.type in (\"STATE\", \"ACTION\")\n" +
            "where ri.code = (\n" +
            "  select o.status from order_info o where o.id = #{orderId, jdbcType=VARCHAR}\n" +
            "  UNION ALL\n" +
            "  select co.status from card_orders_info co where co.id = #{orderId, jdbcType=VARCHAR}\n" +
            "  UNION ALL\n" +
            "  select bo.status from box_orders_info bo where bo.id = #{orderId, jdbcType=VARCHAR}\n" +
            ")\n" +
            "  AND ri.state = '1'")
    BaseDirectoryInfo getOrderStateNextOperationName(BigDecimal orderId);

    /**
     * 通过订单ID查询当前订单状态
     * @param orderId
     * @return
     */
    @Select("select bd.code, bd.name FROM base_directory_info bd\n" +
            "where bd.code = (\n" +
            "  select o.status from order_info o where o.id = #{orderId, jdbcType=VARCHAR}\n" +
            "  UNION ALL\n" +
            "  select co.status from card_orders_info co where co.id = #{orderId, jdbcType=VARCHAR}\n" +
            "  UNION ALL\n" +
            "  select bo.status from box_orders_info bo where bo.id = #{orderId, jdbcType=VARCHAR}\n" +
            ")\n" +
            "      AND bd.state = '1'")
    String selectOrderState(BigDecimal orderId);

}
