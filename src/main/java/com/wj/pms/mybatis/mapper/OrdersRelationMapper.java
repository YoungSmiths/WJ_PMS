package com.wj.pms.mybatis.mapper;

import com.wj.pms.mybatis.entity.OrdersRelation;
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

public interface OrdersRelationMapper {
    @Delete({
        "delete from orders_relation",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal id);

    @Insert({
        "insert into orders_relation (id, order_id, ",
        "parent_id, state, create_by, ",
        "create_time, update_by, ",
        "update_time)",
        "values (#{id,jdbcType=DECIMAL}, #{orderId,jdbcType=DECIMAL}, ",
        "#{parentId,jdbcType=DECIMAL}, #{state,jdbcType=BIT}, #{createBy,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select CONCAT(DATE_FORMAT(NOW(),'%Y%m%d%H%i%s'), floor(RAND() *100000))  from dual", keyProperty="id", before=true, resultType=BigDecimal.class)
    int insert(OrdersRelation record);

    @Select({
        "select",
        "id, order_id, parent_id, state, create_by, create_time, update_by, update_time",
        "from orders_relation",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.DECIMAL),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.DECIMAL),
        @Result(column="state", property="state", jdbcType=JdbcType.BIT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OrdersRelation selectByPrimaryKey(BigDecimal id);

    @Select({
        "select",
        "id, order_id, parent_id, state, create_by, create_time, update_by, update_time",
        "from orders_relation"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.DECIMAL),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.DECIMAL),
        @Result(column="state", property="state", jdbcType=JdbcType.BIT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OrdersRelation> selectAll();

    @Update({
        "update orders_relation",
        "set order_id = #{orderId,jdbcType=DECIMAL},",
          "parent_id = #{parentId,jdbcType=DECIMAL},",
          "state = #{state,jdbcType=BIT},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(OrdersRelation record);
}