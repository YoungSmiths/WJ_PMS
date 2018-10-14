package com.wj.pms.service;

import com.wj.pms.bean.UserBean;
import com.wj.pms.common.util.CheckUtil;
import com.wj.pms.common.Constants;
import com.wj.pms.common.util.SecretUtil;
import com.wj.pms.common.util.SessionUtil;
import com.wj.pms.common.enums.BusinessResponseCodeEnum;
import com.wj.pms.common.exception.BusinessException;
import com.wj.pms.mybatis.entity.DepartmentInfo;
import com.wj.pms.mybatis.entity.PermissionInfo;
import com.wj.pms.mybatis.entity.RoleInfo;
import com.wj.pms.mybatis.entity.UserInfo;
import com.wj.pms.mybatis.mapper.self.BaseService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;


@Service
public class UserService extends BaseService implements UserDetailsService {

    @PostConstruct
    public UserInfo getSystemAdmin() {
        UserInfo system = getUserByCode("system");
        if (system == null) {
            synchronized (this) {
                system = getUserByCode("system");
                if (system == null) {
                    system = new UserInfo();
                    system.setDisplayName("系统管理员");
                    system.setSecret("123456");
                    system.setPhone("13718450920");
                    system.setQq("1347908776");
                    system.setState(true);
                    userInfoMapper.insert(system);
                }
            }
        }
        return userManagerDao.selectUserByCode("system");
    }

    public UserInfo registerUser(UserInfo user) throws BusinessException {
        if (getUserByCode(user.getCode()) != null) {
            throw new BusinessException(BusinessResponseCodeEnum.USER_EXISTED, null);
        }
        userInfoMapper.insert(user);
        return userManagerDao.selectUserByCode(user.getCode());
    }

    public UserInfo getUserByCode(String code) {
        return userManagerDao.selectUserByCode(code);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = getUserByCode(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username " + username + " not found.");
        }
        final UserInfo authenticatedUser = user;
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN"));
            }

            @Override
            public String getPassword() {
                return authenticatedUser.getSecret();
            }

            @Override
            public String getUsername() {
                return authenticatedUser.getDisplayName();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }

    public UserInfo getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getName() != null) {
            return getUserByCode(auth.getName());
        }
        return null;
    }

    public UserBean getUserBean(UserInfo enUser) {
        DepartmentInfo department = userManagerDao.selectDepartment(enUser.getCode());
        List<RoleInfo> roles = userManagerDao.selectRoles(enUser.getCode());
        List<PermissionInfo> permissions = userManagerDao.getUserPermissions(enUser);
        Map<String, Object> map = new HashMap<>();
        // TODO permissions ---> map
        UserBean userBean = new UserBean(enUser, department, roles, permissions);
        return userBean;
    }

    public void resetSecret(HttpSession session, String orderSecret, String newSecret) {
        UserBean userBean = (UserBean) SessionUtil.getAttr(session, Constants.SESSION_USER_KEY);
        BigDecimal id = userBean.getUser().getId();
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        CheckUtil.checkObjNull(userInfo);
        if(!userInfo.getSecret().equals(SecretUtil.encriptSecret(orderSecret))){
            throw new BusinessException(Constants.EC_ORDER_SECRET_WRONG, "老密码错误", null,null);
        } else {
            userInfo.setSecret(SecretUtil.encriptSecret(newSecret));
            userInfoMapper.updateByPrimaryKey(userInfo);
        }
    }

    public void deleteUser(BigDecimal id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        userInfo.setState(false);
        userInfoMapper.updateByPrimaryKey(userInfo);
    }

    public void updateUser(UserInfo user) {
        userInfoMapper.updateByPrimaryKey(user);
    }
}

