package com.wj.pms.mybatis.mapper.self;

import com.wj.pms.mybatis.entity.DepartmentInfo;
import com.wj.pms.mybatis.entity.PermissionInfo;
import com.wj.pms.mybatis.entity.RoleInfo;
import com.wj.pms.mybatis.entity.UserInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserManagerDao {
    @Select("select * from user_info a where a.code = #{code, jdbcType=VARCHAR}")
    UserInfo selectUserByCode(String code);

    @Select("SELECT p.* FROM user_info u\n" +
            "      LEFT JOIN user_role_relation ur on u.id = ur.user_id\n" +
            "      LEFT JOIN role_info r on ur.role_id = r.id\n" +
            "      LEFT JOIN role_permission_relation rp on r.id = rp.role_id\n" +
            "      LEFT JOIN permission_info p on rp.permission_id = p.id\n" +
            "      WHERE u.code = #{code, jdbcType=VARCHAR}")
    List<PermissionInfo> getUserPermissions(UserInfo user);

    @Select("SELECT d.* FROM department_info d\n" +
            "  LEFT JOIN user_department_relation udr on d.id = udr.department_id\n" +
            "  LEFT JOIN user_info u ON udr.user_id = u.id\n" +
            "where u.code = #{code, jdbcType=VARCHAR}")
    DepartmentInfo selectDepartment(String code);

    @Select("SELECT r.* FROM role_info r\n" +
            "LEFT JOIN user_role_relation ur ON r.id = ur.role_id\n" +
            "LEFT JOIN user_info u ON ur.user_id = u.id\n" +
            "WHERE u.code = #{code, jdbcType=VARCHAR}")
    List<RoleInfo> selectRoles(String code);

}
