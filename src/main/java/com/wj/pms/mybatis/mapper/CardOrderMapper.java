package com.wj.pms.mybatis.mapper;

import com.wj.pms.mybatis.entity.CardOrder;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface CardOrderMapper {
    @Delete({
        "delete from card_order",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into card_order (id, card_order_name, ",
        "code, parent_order_id, ",
        "version_house, open_paper, ",
        "print, out_side_hander, ",
        "open_card, blunt_card, ",
        "describe_info, state, ",
        "create_by, create_time, ",
        "update_by, update_time)",
        "values (#{id,jdbcType=VARCHAR}, #{cardOrderName,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{parentOrderId,jdbcType=VARCHAR}, ",
        "#{versionHouse,jdbcType=VARCHAR}, #{openPaper,jdbcType=VARCHAR}, ",
        "#{print,jdbcType=VARCHAR}, #{outSideHander,jdbcType=VARCHAR}, ",
        "#{openCard,jdbcType=VARCHAR}, #{bluntCard,jdbcType=VARCHAR}, ",
        "#{describeInfo,jdbcType=VARCHAR}, #{state,jdbcType=VARCHAR}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(CardOrder record);

    @Select({
        "select",
        "id, card_order_name, code, parent_order_id, version_house, open_paper, print, ",
        "out_side_hander, open_card, blunt_card, describe_info, state, create_by, create_time, ",
        "update_by, update_time",
        "from card_order",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="card_order_name", property="cardOrderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_order_id", property="parentOrderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="version_house", property="versionHouse", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_paper", property="openPaper", jdbcType=JdbcType.VARCHAR),
        @Result(column="print", property="print", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_side_hander", property="outSideHander", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_card", property="openCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="blunt_card", property="bluntCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="describe_info", property="describeInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CardOrder selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, card_order_name, code, parent_order_id, version_house, open_paper, print, ",
        "out_side_hander, open_card, blunt_card, describe_info, state, create_by, create_time, ",
        "update_by, update_time",
        "from card_order"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="card_order_name", property="cardOrderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_order_id", property="parentOrderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="version_house", property="versionHouse", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_paper", property="openPaper", jdbcType=JdbcType.VARCHAR),
        @Result(column="print", property="print", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_side_hander", property="outSideHander", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_card", property="openCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="blunt_card", property="bluntCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="describe_info", property="describeInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CardOrder> selectAll();

    @Update({
        "update card_order",
        "set card_order_name = #{cardOrderName,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "parent_order_id = #{parentOrderId,jdbcType=VARCHAR},",
          "version_house = #{versionHouse,jdbcType=VARCHAR},",
          "open_paper = #{openPaper,jdbcType=VARCHAR},",
          "print = #{print,jdbcType=VARCHAR},",
          "out_side_hander = #{outSideHander,jdbcType=VARCHAR},",
          "open_card = #{openCard,jdbcType=VARCHAR},",
          "blunt_card = #{bluntCard,jdbcType=VARCHAR},",
          "describe_info = #{describeInfo,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(CardOrder record);
}