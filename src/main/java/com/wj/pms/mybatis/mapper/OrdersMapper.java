package com.wj.pms.mybatis.mapper;

import com.wj.pms.mybatis.entity.Orders;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface OrdersMapper {
    @Delete({
        "delete from orders",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into orders (id, order_name, ",
        "order_code, contract_no, ",
        "count, paperType, ",
        "width, lengths, ",
        "print_require, out_side_hander, ",
        "package_require, parts, ",
        "design_pic_path, sub_order_info, ",
        "describe_info, status, ",
        "create_by, create_time, ",
        "update_by, update_time)",
        "values (#{id,jdbcType=VARCHAR}, #{orderName,jdbcType=VARCHAR}, ",
        "#{orderCode,jdbcType=VARCHAR}, #{contractNo,jdbcType=VARCHAR}, ",
        "#{count,jdbcType=VARCHAR}, #{papertype,jdbcType=VARCHAR}, ",
        "#{width,jdbcType=VARCHAR}, #{lengths,jdbcType=VARCHAR}, ",
        "#{printRequire,jdbcType=VARCHAR}, #{outSideHander,jdbcType=VARCHAR}, ",
        "#{packageRequire,jdbcType=VARCHAR}, #{parts,jdbcType=VARCHAR}, ",
        "#{designPicPath,jdbcType=VARCHAR}, #{subOrderInfo,jdbcType=VARCHAR}, ",
        "#{describeInfo,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select CONCAT(DATE_FORMAT(NOW(),'%Y%m%d%H%i%s'), floor(RAND() *100000))  from dual", keyProperty="id", before=true, resultType=String.class)
    int insert(Orders record);

    @Select({
        "select",
        "id, order_name, order_code, contract_no, count, paperType, width, lengths, print_require, ",
        "out_side_hander, package_require, parts, design_pic_path, sub_order_info, describe_info, ",
        "status, create_by, create_time, update_by, update_time",
        "from orders",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="order_name", property="orderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_code", property="orderCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="contract_no", property="contractNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="count", property="count", jdbcType=JdbcType.VARCHAR),
        @Result(column="paperType", property="papertype", jdbcType=JdbcType.VARCHAR),
        @Result(column="width", property="width", jdbcType=JdbcType.VARCHAR),
        @Result(column="lengths", property="lengths", jdbcType=JdbcType.VARCHAR),
        @Result(column="print_require", property="printRequire", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_side_hander", property="outSideHander", jdbcType=JdbcType.VARCHAR),
        @Result(column="package_require", property="packageRequire", jdbcType=JdbcType.VARCHAR),
        @Result(column="parts", property="parts", jdbcType=JdbcType.VARCHAR),
        @Result(column="design_pic_path", property="designPicPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_order_info", property="subOrderInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="describe_info", property="describeInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Orders selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, order_name, order_code, contract_no, count, paperType, width, lengths, print_require, ",
        "out_side_hander, package_require, parts, design_pic_path, sub_order_info, describe_info, ",
        "status, create_by, create_time, update_by, update_time",
        "from orders"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="order_name", property="orderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_code", property="orderCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="contract_no", property="contractNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="count", property="count", jdbcType=JdbcType.VARCHAR),
        @Result(column="paperType", property="papertype", jdbcType=JdbcType.VARCHAR),
        @Result(column="width", property="width", jdbcType=JdbcType.VARCHAR),
        @Result(column="lengths", property="lengths", jdbcType=JdbcType.VARCHAR),
        @Result(column="print_require", property="printRequire", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_side_hander", property="outSideHander", jdbcType=JdbcType.VARCHAR),
        @Result(column="package_require", property="packageRequire", jdbcType=JdbcType.VARCHAR),
        @Result(column="parts", property="parts", jdbcType=JdbcType.VARCHAR),
        @Result(column="design_pic_path", property="designPicPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_order_info", property="subOrderInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="describe_info", property="describeInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Orders> selectAll();

    @Update({
        "update orders",
        "set order_name = #{orderName,jdbcType=VARCHAR},",
          "order_code = #{orderCode,jdbcType=VARCHAR},",
          "contract_no = #{contractNo,jdbcType=VARCHAR},",
          "count = #{count,jdbcType=VARCHAR},",
          "paperType = #{papertype,jdbcType=VARCHAR},",
          "width = #{width,jdbcType=VARCHAR},",
          "lengths = #{lengths,jdbcType=VARCHAR},",
          "print_require = #{printRequire,jdbcType=VARCHAR},",
          "out_side_hander = #{outSideHander,jdbcType=VARCHAR},",
          "package_require = #{packageRequire,jdbcType=VARCHAR},",
          "parts = #{parts,jdbcType=VARCHAR},",
          "design_pic_path = #{designPicPath,jdbcType=VARCHAR},",
          "sub_order_info = #{subOrderInfo,jdbcType=VARCHAR},",
          "describe_info = #{describeInfo,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Orders record);
}