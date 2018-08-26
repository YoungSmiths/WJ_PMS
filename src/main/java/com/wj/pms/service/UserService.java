package com.wj.pms.service;

import com.wj.pms.common.exception.BusinessException;
import com.wj.pms.common.exception.PmsException;
import com.wj.pms.mybatis.entity.User;
import com.wj.pms.mybatis.mapper.UserMapper;
import com.wj.pms.mybatis.mapper.self.PmsDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;


@Service
public class UserService implements UserDetailsService {

    private static final long serialVersionUID = 6581842760139277430L;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PmsDao pmsDao;

    public User getSystemAdmin() {
        User system = getUserByCode("system");
        if (system == null) {
            synchronized (this) {
                system = getUserByCode("system");
                if (system == null) {
                    system = new User();
                    system.setDisplayName("系统管理员");
                    system.setPassword("system");
                    system.setMobile("13718450920");
                    system.setQq("1347908776");
                    system.setState("1");
                    system.setWeChat("13718450920");
                    userMapper.insert(system);
                }
            }
        }
        return pmsDao.selectUserByCode("system");
    }

    public User registerUser(User user) throws BusinessException {
        if (getUserByCode(user.getCode()) != null) {
            throw new BusinessException(1002, "user has existed");
        }
        userMapper.insert(user);
        return pmsDao.selectUserByCode(user.getCode());
    }

    public boolean isUserExisted(String userName) {
        try {
            User user = pmsDao.selectUserByCode(userName);
            return user != null;
        } catch (Exception e) {
            LOGGER.error("Service: isUserExisted({}) error {}", userName, e);
            return false;
        }
    }

    public User getUserByCode(String code) {
        return pmsDao.selectUserByCode(code);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByCode(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username " + username + " not found.");
        }
        final User authenticatedUser = user;
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN"));
            }

            @Override
            public String getPassword() {
                return authenticatedUser.getPassword();
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

    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getName() != null) {
            return getUserByCode(auth.getName());
        }
        return null;
    }
}

