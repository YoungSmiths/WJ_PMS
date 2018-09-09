package com.wj.pms.mybatis.mapper.self;

import com.wj.pms.mybatis.entity.*;
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

    @Select("SELECT p.* FROM user u\n" +
            "      LEFT JOIN user_role ur on u.id = ur.user_id\n" +
            "      LEFT JOIN role r on ur.role_id = r.id\n" +
            "      LEFT JOIN role_permission rp on r.id = rp.role_id\n" +
            "      LEFT JOIN permission p on rp.permission_id = p.id\n" +
            "      WHERE u.code = #{code, jdbcType=VARCHAR}")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="permission_name", property="permissionName", jdbcType=JdbcType.VARCHAR),
            @Result(column="permission_code", property="permissionCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
            @Result(column="describe_info", property="describeInfo", jdbcType=JdbcType.VARCHAR),
            @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Permission> getUserPermissions(User user);

    @Select("SELECT * FROM orders o WHERE o.state = #{list, jdbcType=VARCHAR}")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="order_name", property="orderName", jdbcType=JdbcType.VARCHAR),
            @Result(column="order_code", property="orderCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="contract_no", property="contractNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="count", property="count", jdbcType=JdbcType.VARCHAR),
            @Result(column="paper_type", property="paperType", jdbcType=JdbcType.VARCHAR),
            @Result(column="width", property="width", jdbcType=JdbcType.VARCHAR),
            @Result(column="lengths", property="lengths", jdbcType=JdbcType.VARCHAR),
            @Result(column="print_require", property="printRequire", jdbcType=JdbcType.VARCHAR),
            @Result(column="out_side_hander", property="outSideHander", jdbcType=JdbcType.VARCHAR),
            @Result(column="package_require", property="packageRequire", jdbcType=JdbcType.VARCHAR),
            @Result(column="parts", property="parts", jdbcType=JdbcType.VARCHAR),
            @Result(column="describe_info", property="describeInfo", jdbcType=JdbcType.VARCHAR),
            @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Orders> getOrders4User(String list);


    @Select("select * from order_state_router a where a.state_name = #{name, jdbcType=VARCHAR}")
    void selectByContractNo(String contractNo);

    @Select("select * from order_operate_info a where a.orderId = #{orderId, jdbcType=VARCHAR}")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="orderId", property="orderid", jdbcType=JdbcType.VARCHAR),
            @Result(column="action_code", property="actionCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="action_name", property="actionName", jdbcType=JdbcType.VARCHAR),
            @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OrderOperateInfo> getOrderHistoryByOrderId(String orderId);

    /**
     * 获取订单的状态，可能是父订单，也可能是子订单，并关联baseDirectory
     * @param orderId
     * @return 下一个操作的名字
     */
    @Select("select bd.code, bd.name from router_info ri\n" +
            "  left join\n" +
            "  base_directory bd on ri.next_code = bd.code and bd.type in (\"STATE\", \"ACTION\")\n" +
            "where ri.code = (\n" +
            "  select o.state from orders o where o.id = #{orderId, jdbcType=VARCHAR}\n" +
            "  UNION ALL\n" +
            "  select co.state from card_order co where co.id = #{orderId, jdbcType=VARCHAR}\n" +
            "  UNION ALL\n" +
            "  select bo.state from box_order bo where bo.id = #{orderId, jdbcType=VARCHAR}\n" +
            ")\n" +
            "  AND ri.state = '1'")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    BaseDirectory getOrderStateNextOperationName(String orderId);

    /**
     * 查找该状态下的所有用户，在路由表中找
     * @param state
     * @return
     */
    List<String> getOperationPermitUser(String state);

    /**
     * 通过订单ID查询当前订单状态
     * @param orderId
     * @return
     */
    @Select("select bd.code, bd.name FROM base_directory bd\n" +
            "where bd.code = (\n" +
            "  select o.state from orders o where o.id = #{orderId, jdbcType=VARCHAR}\n" +
            "  UNION ALL\n" +
            "  select co.state from card_order co where co.id = #{orderId, jdbcType=VARCHAR}\n" +
            "  UNION ALL\n" +
            "  select bo.state from box_order bo where bo.id = #{orderId, jdbcType=VARCHAR}\n" +
            ")\n" +
            "      AND bd.state = '1'")
    String selectOrderState(String orderId);

    @Select("SELECT d.* FROM department d\n" +
            "  LEFT JOIN user_department_relation udr on d.id = udr.department_id\n" +
            "  LEFT JOIN user u ON udr.user_id = u.id\n" +
            "where u.code = #{code, jdbcType=VARCHAR}")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="department_name", property="departmentName", jdbcType=JdbcType.VARCHAR),
            @Result(column="department_code", property="departmentCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Department selectDepartment(String code);

    @Select("SELECT r.* FROM role r\n" +
            "LEFT JOIN user_role ur ON r.id = ur.role_id\n" +
            "LEFT JOIN user u ON ur.user_id = u.id\n" +
            "WHERE u.code = #{code, jdbcType=VARCHAR}")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="role_code", property="roleCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
            @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Role> selectRoles(String code);

}
