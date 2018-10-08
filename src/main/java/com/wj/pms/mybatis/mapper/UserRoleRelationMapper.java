package com.wj.pms.mybatis.mapper;

import com.wj.pms.mybatis.entity.UserRoleRelation;
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

public interface UserRoleRelationMapper {
    @Delete({
        "delete from user_role_relation",
        "where Id = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal id);

    @Insert({
        "insert into user_role_relation (Id, user_id, ",
        "role_id, state, create_by, ",
        "create_time, update_by, ",
        "update_time)",
        "values (#{id,jdbcType=DECIMAL}, #{userId,jdbcType=DECIMAL}, ",
        "#{roleId,jdbcType=DECIMAL}, #{state,jdbcType=BIT}, #{createBy,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select CONCAT(DATE_FORMAT(NOW(),'%Y%m%d%H%i%s'), floor(RAND() *100000))  from dual", keyProperty="id", before=true, resultType=BigDecimal.class)
    int insert(UserRoleRelation record);

    @Select({
        "select",
        "Id, user_id, role_id, state, create_by, create_time, update_by, update_time",
        "from user_role_relation",
        "where Id = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.DECIMAL),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.DECIMAL),
        @Result(column="state", property="state", jdbcType=JdbcType.BIT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    UserRoleRelation selectByPrimaryKey(BigDecimal id);

    @Select({
        "select",
        "Id, user_id, role_id, state, create_by, create_time, update_by, update_time",
        "from user_role_relation"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.DECIMAL),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.DECIMAL),
        @Result(column="state", property="state", jdbcType=JdbcType.BIT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserRoleRelation> selectAll();

    @Update({
        "update user_role_relation",
        "set user_id = #{userId,jdbcType=DECIMAL},",
          "role_id = #{roleId,jdbcType=DECIMAL},",
          "state = #{state,jdbcType=BIT},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where Id = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(UserRoleRelation record);
}