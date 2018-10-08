package com.wj.pms.mybatis.mapper;

import com.wj.pms.mybatis.entity.PermissionInfo;
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

public interface PermissionInfoMapper {
    @Delete({
        "delete from permission_info",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal id);

    @Insert({
        "insert into permission_info (id, permission_name, ",
        "permission_code, content, ",
        "describe_info, state, ",
        "create_by, create_time, ",
        "update_by, update_time)",
        "values (#{id,jdbcType=DECIMAL}, #{permissionName,jdbcType=VARCHAR}, ",
        "#{permissionCode,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{describeInfo,jdbcType=VARCHAR}, #{state,jdbcType=BIT}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select CONCAT(DATE_FORMAT(NOW(),'%Y%m%d%H%i%s'), floor(RAND() *100000))  from dual", keyProperty="id", before=true, resultType=BigDecimal.class)
    int insert(PermissionInfo record);

    @Select({
        "select",
        "id, permission_name, permission_code, content, describe_info, state, create_by, ",
        "create_time, update_by, update_time",
        "from permission_info",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="permission_name", property="permissionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission_code", property="permissionCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="describe_info", property="describeInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.BIT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PermissionInfo selectByPrimaryKey(BigDecimal id);

    @Select({
        "select",
        "id, permission_name, permission_code, content, describe_info, state, create_by, ",
        "create_time, update_by, update_time",
        "from permission_info"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="permission_name", property="permissionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission_code", property="permissionCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="describe_info", property="describeInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.BIT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PermissionInfo> selectAll();

    @Update({
        "update permission_info",
        "set permission_name = #{permissionName,jdbcType=VARCHAR},",
          "permission_code = #{permissionCode,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "describe_info = #{describeInfo,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=BIT},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(PermissionInfo record);
}