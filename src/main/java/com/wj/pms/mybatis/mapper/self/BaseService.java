package com.wj.pms.mybatis.mapper.self;

import com.wj.pms.mybatis.entity.OrdersRelation;
import com.wj.pms.mybatis.mapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-8-12 上午7:53
 */
public class BaseService {

    @Autowired
    protected  UserManagerDao userManagerDao;

    @Autowired
    protected PmsDao pmsDao;

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
