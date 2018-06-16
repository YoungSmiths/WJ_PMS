package com.wj.pms.common.mapper;

import com.wj.pms.common.model.PermissionInfo;
import com.wj.pms.common.model.PermissionInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionInfoMapper {
    int countByExample(PermissionInfoExample example);

    int deleteByExample(PermissionInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PermissionInfo record);

    int insertSelective(PermissionInfo record);

    List<PermissionInfo> selectByExample(PermissionInfoExample example);

    PermissionInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PermissionInfo record, @Param("example") PermissionInfoExample example);

    int updateByExample(@Param("record") PermissionInfo record, @Param("example") PermissionInfoExample example);

    int updateByPrimaryKeySelective(PermissionInfo record);

    int updateByPrimaryKey(PermissionInfo record);
}