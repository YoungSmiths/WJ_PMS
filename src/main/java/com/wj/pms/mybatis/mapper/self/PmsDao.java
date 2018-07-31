package com.wj.pms.mybatis.mapper.self;

import com.wj.pms.mybatis.entity.OrderStateRouter;
import com.wj.pms.mybatis.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-7-31 上午7:24
 */
public interface PmsDao {
    @Select("select * from user a where a.name = #{name, jdbcType=VARCHAR}")
    User selectUserByName(String name);

    @Select("select * from order_state_router a where a.state_name = #{name, jdbcType=VARCHAR}")
    OrderStateRouter selectOrderStateRouterByStateName(String name);
}
