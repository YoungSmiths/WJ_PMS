package com.wj.pms.mybatis.mapper;

import com.wj.pms.mybatis.entity.OrderOperateInfo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface OrderOperateInfoMapper {
    @Delete({
        "delete from order_operate_info",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into order_operate_info (id, orderId, ",
        "action_code, action_name, ",
        "state, create_by, ",
        "create_time, update_by, ",
        "update_time)",
        "values (#{id,jdbcType=VARCHAR}, #{orderid,jdbcType=VARCHAR}, ",
        "#{actionCode,jdbcType=VARCHAR}, #{actionName,jdbcType=VARCHAR}, ",
        "#{state,jdbcType=VARCHAR}, #{createBy,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(OrderOperateInfo record);

    @Select({
        "select",
        "id, orderId, action_code, action_name, state, create_by, create_time, update_by, ",
        "update_time",
        "from order_operate_info",
        "where id = #{id,jdbcType=VARCHAR}"
    })
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
    OrderOperateInfo selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, orderId, action_code, action_name, state, create_by, create_time, update_by, ",
        "update_time",
        "from order_operate_info"
    })
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
    List<OrderOperateInfo> selectAll();

    @Update({
        "update order_operate_info",
        "set orderId = #{orderid,jdbcType=VARCHAR},",
          "action_code = #{actionCode,jdbcType=VARCHAR},",
          "action_name = #{actionName,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(OrderOperateInfo record);
}