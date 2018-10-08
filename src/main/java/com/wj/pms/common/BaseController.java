package com.wj.pms.common;

import com.wj.pms.mybatis.mapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("baseController")
public class BaseController {
    protected static Logger log = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    protected BaseDirectoryInfoMapper baseDirectoryInfoMapper;

    @Autowired
    protected BoxOrdersInfoMapper boxOrdersInfoMapper;

    @Autowired
    protected CardOrdersInfoMapper cardOrdersInfoMapper;

    @Autowired
    protected DepartmentInfoMapper departmentInfoMapper;

    @Autowired
    protected ExceptionInfoMapper exceptionInfoMapper;

    @Autowired
    protected OrderInfoMapper orderInfoMapper;

    @Autowired
    protected OrderOperateRecordInfoMapper orderOperateRecordInfoMapper;

    @Autowired
    protected OrdersRelationMapper ordersRelationMapper;

    @Autowired
    protected PermissionInfoMapper permissionInfoMapper;

    @Autowired
    protected RoleInfoMapper roleInfoMapper;

    @Autowired
    protected RolePermissionRelationMapper rolePermissionRelationMapper;

    @Autowired
    protected RouterInfoMapper routerInfoMapper;

    @Autowired
    protected UserDepartmentRelationMapper userDepartmentRelationMapper;

    @Autowired
    protected UserInfoMapper userInfoMapper;

    @Autowired
    protected UserRoleRelationMapper userRoleRelationMapper;

}
