package com.wj.pms.mybatis.mapper;

import com.wj.pms.mybatis.entity.OrderOperateRecordInfo;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface OrderOperateRecordInfoMapper {
    @Delete({
        "delete from order_operate_record_info",
        "where Id = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal id);

    @Insert({
        "insert into order_operate_record_info (Id, action_code, ",
        "action_name, order_id, ",
        "create_by, create_time, ",
        "update_by, update_time)",
        "values (#{id,jdbcType=DECIMAL}, #{actionCode,jdbcType=VARCHAR}, ",
        "#{actionName,jdbcType=VARCHAR}, #{orderId,jdbcType=DECIMAL}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select CONCAT(DATE_FORMAT(NOW(),'%Y%m%d%H%i%s'), floor(RAND() *100000))  from dual", keyProperty="id", before=true, resultType=BigDecimal.class)
    int insert(OrderOperateRecordInfo record);

    @Select({
        "select",
        "Id, action_code, action_name, order_id, create_by, create_time, update_by, update_time",
        "from order_operate_record_info",
        "where Id = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="action_code", property="actionCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="action_name", property="actionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OrderOperateRecordInfo selectByPrimaryKey(BigDecimal id);

    @Select({
        "select",
        "Id, action_code, action_name, order_id, create_by, create_time, update_by, update_time",
        "from order_operate_record_info"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="action_code", property="actionCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="action_name", property="actionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OrderOperateRecordInfo> selectAll();

    @Update({
        "update order_operate_record_info",
        "set action_code = #{actionCode,jdbcType=VARCHAR},",
          "action_name = #{actionName,jdbcType=VARCHAR},",
          "order_id = #{orderId,jdbcType=DECIMAL},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where Id = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(OrderOperateRecordInfo record);
}