package com.wj.pms.mybatis.mapper;

import com.wj.pms.mybatis.entity.ExceptionInfo;
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

public interface ExceptionInfoMapper {
    @Delete({
        "delete from exception_info",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal id);

    @Insert({
        "insert into exception_info (id, exception_code, ",
        "message, order_id, ",
        "create_by, create_time, ",
        "update_by, update_time)",
        "values (#{id,jdbcType=DECIMAL}, #{exceptionCode,jdbcType=VARCHAR}, ",
        "#{message,jdbcType=VARCHAR}, #{orderId,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select CONCAT(DATE_FORMAT(NOW(),'%Y%m%d%H%i%s'), floor(RAND() *100000))  from dual", keyProperty="id", before=true, resultType=BigDecimal.class)
    int insert(ExceptionInfo record);

    @Select({
        "select",
        "id, exception_code, message, order_id, create_by, create_time, update_by, update_time",
        "from exception_info",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="exception_code", property="exceptionCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ExceptionInfo selectByPrimaryKey(BigDecimal id);

    @Select({
        "select",
        "id, exception_code, message, order_id, create_by, create_time, update_by, update_time",
        "from exception_info"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="exception_code", property="exceptionCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ExceptionInfo> selectAll();

    @Update({
        "update exception_info",
        "set exception_code = #{exceptionCode,jdbcType=VARCHAR},",
          "message = #{message,jdbcType=VARCHAR},",
          "order_id = #{orderId,jdbcType=INTEGER},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(ExceptionInfo record);
}