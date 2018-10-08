package com.wj.pms.mybatis.mapper;

import com.wj.pms.mybatis.entity.OrderInfo;
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

public interface OrderInfoMapper {
    @Delete({
        "delete from order_info",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal id);

    @Insert({
        "insert into order_info (id, order_name, ",
        "order_code, contract_no, ",
        "edition, customer, ",
        "product_name, order_start_date, ",
        "dead_line, count, ",
        "paper_type, width, ",
        "lengths, print_require, ",
        "out_side_handler, package_require, ",
        "parts, design_pic_path, ",
        "describe_info, status, ",
        "create_by, create_time, ",
        "update_by, update_time)",
        "values (#{id,jdbcType=DECIMAL}, #{orderName,jdbcType=VARCHAR}, ",
        "#{orderCode,jdbcType=VARCHAR}, #{contractNo,jdbcType=VARCHAR}, ",
        "#{edition,jdbcType=VARCHAR}, #{customer,jdbcType=VARCHAR}, ",
        "#{productName,jdbcType=VARCHAR}, #{orderStartDate,jdbcType=TIMESTAMP}, ",
        "#{deadLine,jdbcType=TIMESTAMP}, #{count,jdbcType=INTEGER}, ",
        "#{paperType,jdbcType=VARCHAR}, #{width,jdbcType=VARCHAR}, ",
        "#{lengths,jdbcType=VARCHAR}, #{printRequire,jdbcType=VARCHAR}, ",
        "#{outSideHandler,jdbcType=VARCHAR}, #{packageRequire,jdbcType=VARCHAR}, ",
        "#{parts,jdbcType=VARCHAR}, #{designPicPath,jdbcType=VARCHAR}, ",
        "#{describeInfo,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select CONCAT(DATE_FORMAT(NOW(),'%Y%m%d%H%i%s'), floor(RAND() *100000))  from dual", keyProperty="id", before=true, resultType=BigDecimal.class)
    int insert(OrderInfo record);

    @Select({
        "select",
        "id, order_name, order_code, contract_no, edition, customer, product_name, order_start_date, ",
        "dead_line, count, paper_type, width, lengths, print_require, out_side_handler, ",
        "package_require, parts, design_pic_path, describe_info, status, create_by, create_time, ",
        "update_by, update_time",
        "from order_info",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="order_name", property="orderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_code", property="orderCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="contract_no", property="contractNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="edition", property="edition", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer", property="customer", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_start_date", property="orderStartDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="dead_line", property="deadLine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="count", property="count", jdbcType=JdbcType.INTEGER),
        @Result(column="paper_type", property="paperType", jdbcType=JdbcType.VARCHAR),
        @Result(column="width", property="width", jdbcType=JdbcType.VARCHAR),
        @Result(column="lengths", property="lengths", jdbcType=JdbcType.VARCHAR),
        @Result(column="print_require", property="printRequire", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_side_handler", property="outSideHandler", jdbcType=JdbcType.VARCHAR),
        @Result(column="package_require", property="packageRequire", jdbcType=JdbcType.VARCHAR),
        @Result(column="parts", property="parts", jdbcType=JdbcType.VARCHAR),
        @Result(column="design_pic_path", property="designPicPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="describe_info", property="describeInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OrderInfo selectByPrimaryKey(BigDecimal id);

    @Select({
        "select",
        "id, order_name, order_code, contract_no, edition, customer, product_name, order_start_date, ",
        "dead_line, count, paper_type, width, lengths, print_require, out_side_handler, ",
        "package_require, parts, design_pic_path, describe_info, status, create_by, create_time, ",
        "update_by, update_time",
        "from order_info"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="order_name", property="orderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_code", property="orderCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="contract_no", property="contractNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="edition", property="edition", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer", property="customer", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_start_date", property="orderStartDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="dead_line", property="deadLine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="count", property="count", jdbcType=JdbcType.INTEGER),
        @Result(column="paper_type", property="paperType", jdbcType=JdbcType.VARCHAR),
        @Result(column="width", property="width", jdbcType=JdbcType.VARCHAR),
        @Result(column="lengths", property="lengths", jdbcType=JdbcType.VARCHAR),
        @Result(column="print_require", property="printRequire", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_side_handler", property="outSideHandler", jdbcType=JdbcType.VARCHAR),
        @Result(column="package_require", property="packageRequire", jdbcType=JdbcType.VARCHAR),
        @Result(column="parts", property="parts", jdbcType=JdbcType.VARCHAR),
        @Result(column="design_pic_path", property="designPicPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="describe_info", property="describeInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OrderInfo> selectAll();

    @Update({
        "update order_info",
        "set order_name = #{orderName,jdbcType=VARCHAR},",
          "order_code = #{orderCode,jdbcType=VARCHAR},",
          "contract_no = #{contractNo,jdbcType=VARCHAR},",
          "edition = #{edition,jdbcType=VARCHAR},",
          "customer = #{customer,jdbcType=VARCHAR},",
          "product_name = #{productName,jdbcType=VARCHAR},",
          "order_start_date = #{orderStartDate,jdbcType=TIMESTAMP},",
          "dead_line = #{deadLine,jdbcType=TIMESTAMP},",
          "count = #{count,jdbcType=INTEGER},",
          "paper_type = #{paperType,jdbcType=VARCHAR},",
          "width = #{width,jdbcType=VARCHAR},",
          "lengths = #{lengths,jdbcType=VARCHAR},",
          "print_require = #{printRequire,jdbcType=VARCHAR},",
          "out_side_handler = #{outSideHandler,jdbcType=VARCHAR},",
          "package_require = #{packageRequire,jdbcType=VARCHAR},",
          "parts = #{parts,jdbcType=VARCHAR},",
          "design_pic_path = #{designPicPath,jdbcType=VARCHAR},",
          "describe_info = #{describeInfo,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(OrderInfo record);
}