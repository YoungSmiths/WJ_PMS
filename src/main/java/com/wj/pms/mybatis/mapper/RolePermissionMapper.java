package com.wj.pms.mybatis.mapper;

import com.wj.pms.mybatis.entity.RolePermission;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface RolePermissionMapper {
    @Delete({
        "delete from role_permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into role_permission (id, role_id, ",
        "permission_id, state, ",
        "create_by, create_time, ",
        "update_by, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER}, ",
        "#{permissionId,jdbcType=INTEGER}, #{state,jdbcType=VARCHAR}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select CONCAT(DATE_FORMAT(NOW(),'%Y%m%d%H%i%s'), floor(RAND() *100000))  from dual", keyProperty="id", before=true, resultType=Integer.class)
    int insert(RolePermission record);

    @Select({
        "select",
        "id, role_id, permission_id, state, create_by, create_time, update_by, update_time",
        "from role_permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RolePermission selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, role_id, permission_id, state, create_by, create_time, update_by, update_time",
        "from role_permission"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RolePermission> selectAll();

    @Update({
        "update role_permission",
        "set role_id = #{roleId,jdbcType=INTEGER},",
          "permission_id = #{permissionId,jdbcType=INTEGER},",
          "state = #{state,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RolePermission record);
}