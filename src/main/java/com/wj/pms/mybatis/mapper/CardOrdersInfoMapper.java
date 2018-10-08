package com.wj.pms.mybatis.mapper;

import com.wj.pms.mybatis.entity.CardOrdersInfo;
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

public interface CardOrdersInfoMapper {
    @Delete({
        "delete from card_orders_info",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal id);

    @Insert({
        "insert into card_orders_info (id, card_order_name, ",
        "card_order_code, version_house, ",
        "open_paper, print, ",
        "out_side_hander, open_card, ",
        "blunt_card, describe_info, ",
        "status, create_by, ",
        "create_time, update_by, ",
        "update_time)",
        "values (#{id,jdbcType=DECIMAL}, #{cardOrderName,jdbcType=VARCHAR}, ",
        "#{cardOrderCode,jdbcType=VARCHAR}, #{versionHouse,jdbcType=VARCHAR}, ",
        "#{openPaper,jdbcType=VARCHAR}, #{print,jdbcType=VARCHAR}, ",
        "#{outSideHander,jdbcType=VARCHAR}, #{openCard,jdbcType=VARCHAR}, ",
        "#{bluntCard,jdbcType=VARCHAR}, #{describeInfo,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{createBy,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select CONCAT(DATE_FORMAT(NOW(),'%Y%m%d%H%i%s'), floor(RAND() *100000))  from dual", keyProperty="id", before=true, resultType=BigDecimal.class)
    int insert(CardOrdersInfo record);

    @Select({
        "select",
        "id, card_order_name, card_order_code, version_house, open_paper, print, out_side_hander, ",
        "open_card, blunt_card, describe_info, status, create_by, create_time, update_by, ",
        "update_time",
        "from card_orders_info",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="card_order_name", property="cardOrderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_order_code", property="cardOrderCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="version_house", property="versionHouse", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_paper", property="openPaper", jdbcType=JdbcType.VARCHAR),
        @Result(column="print", property="print", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_side_hander", property="outSideHander", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_card", property="openCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="blunt_card", property="bluntCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="describe_info", property="describeInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CardOrdersInfo selectByPrimaryKey(BigDecimal id);

    @Select({
        "select",
        "id, card_order_name, card_order_code, version_house, open_paper, print, out_side_hander, ",
        "open_card, blunt_card, describe_info, status, create_by, create_time, update_by, ",
        "update_time",
        "from card_orders_info"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="card_order_name", property="cardOrderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_order_code", property="cardOrderCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="version_house", property="versionHouse", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_paper", property="openPaper", jdbcType=JdbcType.VARCHAR),
        @Result(column="print", property="print", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_side_hander", property="outSideHander", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_card", property="openCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="blunt_card", property="bluntCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="describe_info", property="describeInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CardOrdersInfo> selectAll();

    @Update({
        "update card_orders_info",
        "set card_order_name = #{cardOrderName,jdbcType=VARCHAR},",
          "card_order_code = #{cardOrderCode,jdbcType=VARCHAR},",
          "version_house = #{versionHouse,jdbcType=VARCHAR},",
          "open_paper = #{openPaper,jdbcType=VARCHAR},",
          "print = #{print,jdbcType=VARCHAR},",
          "out_side_hander = #{outSideHander,jdbcType=VARCHAR},",
          "open_card = #{openCard,jdbcType=VARCHAR},",
          "blunt_card = #{bluntCard,jdbcType=VARCHAR},",
          "describe_info = #{describeInfo,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(CardOrdersInfo record);
}