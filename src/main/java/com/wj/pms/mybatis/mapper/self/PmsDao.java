package com.wj.pms.mybatis.mapper.self;

import com.wj.pms.mybatis.entity.OrderStateRouter;
import com.wj.pms.mybatis.entity.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-7-31 上午7:24
 */
public interface PmsDao {
    @Select("select * from user a where a.code = #{code, jdbcType=VARCHAR}")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
            @Result(column="display_name", property="displayName", jdbcType=JdbcType.VARCHAR),
            @Result(column="id_no", property="idNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="birthday", property="birthday", jdbcType=JdbcType.VARCHAR),
            @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
            @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
            @Result(column="we_chat", property="weChat", jdbcType=JdbcType.VARCHAR),
            @Result(column="mail", property="mail", jdbcType=JdbcType.VARCHAR),
            @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectUserByCode(String code);

    @Select("select * from order_state_router a where a.state_name = #{name, jdbcType=VARCHAR}")
    OrderStateRouter selectOrderStateRouterByStateName(String name);
}
