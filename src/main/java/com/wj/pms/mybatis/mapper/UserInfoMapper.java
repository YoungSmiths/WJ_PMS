package com.wj.pms.mybatis.mapper;

import com.wj.pms.mybatis.entity.UserInfo;
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

public interface UserInfoMapper {
    @Delete({
        "delete from user_info",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal id);

    @Insert({
        "insert into user_info (id, display_name, ",
        "code, id_no, birthday, ",
        "sex, phone, qq, ",
        "secret, state, create_by, ",
        "create_time, update_by, ",
        "update_time)",
        "values (#{id,jdbcType=DECIMAL}, #{displayName,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{idNo,jdbcType=VARCHAR}, #{birthday,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{qq,jdbcType=VARCHAR}, ",
        "#{secret,jdbcType=VARCHAR}, #{state,jdbcType=BIT}, #{createBy,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select CONCAT(DATE_FORMAT(NOW(),'%Y%m%d%H%i%s'), floor(RAND() *100000))  from dual", keyProperty="id", before=true, resultType=BigDecimal.class)
    int insert(UserInfo record);

    @Select({
        "select",
        "id, display_name, code, id_no, birthday, sex, phone, qq, secret, state, create_by, ",
        "create_time, update_by, update_time",
        "from user_info",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="display_name", property="displayName", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_no", property="idNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="secret", property="secret", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.BIT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    UserInfo selectByPrimaryKey(BigDecimal id);

    @Select({
        "select",
        "id, display_name, code, id_no, birthday, sex, phone, qq, secret, state, create_by, ",
        "create_time, update_by, update_time",
        "from user_info"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="display_name", property="displayName", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_no", property="idNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="secret", property="secret", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.BIT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserInfo> selectAll();

    @Update({
        "update user_info",
        "set display_name = #{displayName,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "id_no = #{idNo,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "qq = #{qq,jdbcType=VARCHAR},",
          "secret = #{secret,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=BIT},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(UserInfo record);
}