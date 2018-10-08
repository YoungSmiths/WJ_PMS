package com.wj.pms.mybatis.mapper;

import com.wj.pms.mybatis.entity.RolePermissionRelation;
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

public interface RolePermissionRelationMapper {
    @Delete({
        "delete from role_permission_relation",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal id);

    @Insert({
        "insert into role_permission_relation (id, role_id, ",
        "permission_id, state, ",
        "create_by, create_time, ",
        "update_by, update_time)",
        "values (#{id,jdbcType=DECIMAL}, #{roleId,jdbcType=VARCHAR}, ",
        "#{permissionId,jdbcType=VARCHAR}, #{state,jdbcType=BIT}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select CONCAT(DATE_FORMAT(NOW(),'%Y%m%d%H%i%s'), floor(RAND() *100000))  from dual", keyProperty="id", before=true, resultType=BigDecimal.class)
    int insert(RolePermissionRelation record);

    @Select({
        "select",
        "id, role_id, permission_id, state, create_by, create_time, update_by, update_time",
        "from role_permission_relation",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.BIT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RolePermissionRelation selectByPrimaryKey(BigDecimal id);

    @Select({
        "select",
        "id, role_id, permission_id, state, create_by, create_time, update_by, update_time",
        "from role_permission_relation"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.BIT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RolePermissionRelation> selectAll();

    @Update({
        "update role_permission_relation",
        "set role_id = #{roleId,jdbcType=VARCHAR},",
          "permission_id = #{permissionId,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=BIT},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(RolePermissionRelation record);
}