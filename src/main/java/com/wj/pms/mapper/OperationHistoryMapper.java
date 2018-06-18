package com.wj.pms.mapper;

import com.wj.pms.model.OperationHistory;
import com.wj.pms.model.OperationHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationHistoryMapper {
    int countByExample(OperationHistoryExample example);

    int deleteByExample(OperationHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperationHistory record);

    int insertSelective(OperationHistory record);

    List<OperationHistory> selectByExample(OperationHistoryExample example);

    OperationHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperationHistory record, @Param("example") OperationHistoryExample example);

    int updateByExample(@Param("record") OperationHistory record, @Param("example") OperationHistoryExample example);

    int updateByPrimaryKeySelective(OperationHistory record);

    int updateByPrimaryKey(OperationHistory record);
}