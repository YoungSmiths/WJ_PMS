package com.wj.pms.mybatis.mapper;

import com.wj.pms.mybatis.entity.BoxOrder;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BoxOrderMapper {
    @Delete({
        "delete from box_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into box_order (id, box_order_name, ",
        "box_order_code, parent_order_id, ",
        "version_house, open_paper, ",
        "print, out_side_hander, ",
        "box_beer, box_sticky, ",
        "state, describe_info, ",
        "create_by, create_time, ",
        "update_by, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{boxOrderName,jdbcType=VARCHAR}, ",
        "#{boxOrderCode,jdbcType=VARCHAR}, #{parentOrderId,jdbcType=INTEGER}, ",
        "#{versionHouse,jdbcType=VARCHAR}, #{openPaper,jdbcType=VARCHAR}, ",
        "#{print,jdbcType=VARCHAR}, #{outSideHander,jdbcType=VARCHAR}, ",
        "#{boxBeer,jdbcType=VARCHAR}, #{boxSticky,jdbcType=VARCHAR}, ",
        "#{state,jdbcType=VARCHAR}, #{describeInfo,jdbcType=VARCHAR}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select CONCAT(DATE_FORMAT(NOW(),'%Y%m%d%H%i%s'), floor(RAND() *100000))  from dual", keyProperty="id", before=true, resultType=Integer.class)
    int insert(BoxOrder record);

    @Select({
        "select",
        "id, box_order_name, box_order_code, parent_order_id, version_house, open_paper, ",
        "print, out_side_hander, box_beer, box_sticky, state, describe_info, create_by, ",
        "create_time, update_by, update_time",
        "from box_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="box_order_name", property="boxOrderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="box_order_code", property="boxOrderCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_order_id", property="parentOrderId", jdbcType=JdbcType.INTEGER),
        @Result(column="version_house", property="versionHouse", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_paper", property="openPaper", jdbcType=JdbcType.VARCHAR),
        @Result(column="print", property="print", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_side_hander", property="outSideHander", jdbcType=JdbcType.VARCHAR),
        @Result(column="box_beer", property="boxBeer", jdbcType=JdbcType.VARCHAR),
        @Result(column="box_sticky", property="boxSticky", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="describe_info", property="describeInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    BoxOrder selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, box_order_name, box_order_code, parent_order_id, version_house, open_paper, ",
        "print, out_side_hander, box_beer, box_sticky, state, describe_info, create_by, ",
        "create_time, update_by, update_time",
        "from box_order"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="box_order_name", property="boxOrderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="box_order_code", property="boxOrderCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_order_id", property="parentOrderId", jdbcType=JdbcType.INTEGER),
        @Result(column="version_house", property="versionHouse", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_paper", property="openPaper", jdbcType=JdbcType.VARCHAR),
        @Result(column="print", property="print", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_side_hander", property="outSideHander", jdbcType=JdbcType.VARCHAR),
        @Result(column="box_beer", property="boxBeer", jdbcType=JdbcType.VARCHAR),
        @Result(column="box_sticky", property="boxSticky", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="describe_info", property="describeInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BoxOrder> selectAll();

    @Update({
        "update box_order",
        "set box_order_name = #{boxOrderName,jdbcType=VARCHAR},",
          "box_order_code = #{boxOrderCode,jdbcType=VARCHAR},",
          "parent_order_id = #{parentOrderId,jdbcType=INTEGER},",
          "version_house = #{versionHouse,jdbcType=VARCHAR},",
          "open_paper = #{openPaper,jdbcType=VARCHAR},",
          "print = #{print,jdbcType=VARCHAR},",
          "out_side_hander = #{outSideHander,jdbcType=VARCHAR},",
          "box_beer = #{boxBeer,jdbcType=VARCHAR},",
          "box_sticky = #{boxSticky,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=VARCHAR},",
          "describe_info = #{describeInfo,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BoxOrder record);
}