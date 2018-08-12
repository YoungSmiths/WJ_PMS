package com.wj.pms.mybatis.mapper.self;

import com.wj.pms.bean.PermissionBean;
import com.wj.pms.mybatis.entity.OrderStateRouter;
import com.wj.pms.mybatis.entity.Orders;
import com.wj.pms.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

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

    @Select("SELECT p.content FROM (SELECT * FROM user where code =  #{code, jdbcType=VARCHAR}) u\n" +
            "  LEFT JOIN user_role ur on u.id = ur.user_id\n" +
            "  LEFT JOIN role r on ur.role_id = r.id\n" +
            "  LEFT JOIN role_permission rp on r.id = rp.role_id\n" +
            "  LEFT JOIN permission p on rp.permission_id = p.id")
    List<String> getUserPermissions(User user);

    @Select("SELECT * FROM orders o WHERE o.state IN #{list}")
    List<Orders> getOrders4User(@Param("list") List<String> list);

    @Select("select * from order_state_router a where a.state_name = #{name, jdbcType=VARCHAR}")
    OrderStateRouter selectOrderStateRouterByStateName(String name);
}
