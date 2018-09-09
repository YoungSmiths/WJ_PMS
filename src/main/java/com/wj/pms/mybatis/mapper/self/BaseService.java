package com.wj.pms.mybatis.mapper.self;

import com.wj.pms.mybatis.entity.Orders;
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
    protected PmsDao pmsDao;

    @Autowired
    protected BaseDirectoryMapper baseDirectoryMapper;
    @Autowired
    protected BoxOrderMapper boxOrderMapper;
    @Autowired
    protected CardOrderMapper cardOrderMapper;
    @Autowired
    protected DepartmentMapper departmentMapper;
    @Autowired
    protected ExceptionMapper exceptionMapper;
    @Autowired
    protected OrderOperateInfoMapper orderOperateInfoMapper;
    @Autowired
    protected OrdersMapper ordersMapper;
    @Autowired
    protected PermissionMapper permissionMapper;
    @Autowired
    protected RoleMapper roleMapper;
    @Autowired
    protected RolePermissionMapper rolePermissionMapper;
    @Autowired
    protected RouterInfoMapper routerInfoMapper;
    @Autowired
    protected UserDepartmentRelationMapper userDepartmentRelationMapper;
    @Autowired
    protected UserMapper userMapper;
    @Autowired
    protected UserRoleMapper userRoleMapper;
}
