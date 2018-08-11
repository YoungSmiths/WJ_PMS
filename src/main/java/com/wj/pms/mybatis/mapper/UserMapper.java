package com.wj.pms.mybatis.mapper;

import com.wj.pms.mybatis.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into user (id, code, ",
        "display_name, id_no, ",
        "password, birthday, ",
        "sex, phone, mobile, ",
        "qq, we_chat, mail, ",
        "state, create_by, ",
        "create_time, update_by, ",
        "update_time)",
        "values (#{id,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR}, ",
        "#{displayName,jdbcType=VARCHAR}, #{idNo,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{birthday,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
        "#{qq,jdbcType=VARCHAR}, #{weChat,jdbcType=VARCHAR}, #{mail,jdbcType=VARCHAR}, ",
        "#{state,jdbcType=VARCHAR}, #{createBy,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select CONCAT(DATE_FORMAT(NOW(),'%Y%m%d%H%i%s'), floor(RAND() *100000))  from dual", keyProperty="id", before=true, resultType=String.class)
    int insert(User record);

    @Select({
        "select",
        "id, code, display_name, id_no, password, birthday, sex, phone, mobile, qq, we_chat, ",
        "mail, state, create_by, create_time, update_by, update_time",
        "from user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
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
    User selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, code, display_name, id_no, password, birthday, sex, phone, mobile, qq, we_chat, ",
        "mail, state, create_by, create_time, update_by, update_time",
        "from user"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
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
    List<User> selectAll();

    @Update({
        "update user",
        "set code = #{code,jdbcType=VARCHAR},",
          "display_name = #{displayName,jdbcType=VARCHAR},",
          "id_no = #{idNo,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "qq = #{qq,jdbcType=VARCHAR},",
          "we_chat = #{weChat,jdbcType=VARCHAR},",
          "mail = #{mail,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
}