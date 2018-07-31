package com.wj.pms.service;

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
import java.util.List;

/**
 * Created by shiy on 2017/7/22.
 */
@Service
public class UserService implements UserDetailsService {

    private static final long serialVersionUID = 6581842760139277430L;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PmsDao pmsDao;

    public User getAdminUser() {
        User admin = getUserByName("admin");
        if (admin == null) {
            synchronized (this) {
                admin = getUserByName("admin");
                if (admin == null) {
                    admin = new User();
                    admin.setName("admin");
                    admin.setPassword("admin");
                    admin.setDisplayName("Administrator");
                    admin.setMobile("13718450920");
                    admin.setQq("1347908776");
                    admin.setDisplayName("石洋");
                    admin.setState("1");
                    admin.setWeChat("13718450920");
                    userMapper.insert(admin);
                }
            }
        }
        return pmsDao.selectUserByName("admin");
    }

    public User registerUser(User user) throws PmsException {
        if (getUserByName(user.getName()) != null) {
            throw new PmsException(1002, "user has existed");
        }
        user.setPassword(user.getPassword());
        userMapper.insert(user);
        return pmsDao.selectUserByName(user.getName());
    }

    public boolean isUserExisted(String userName) {
        try {
            User user = pmsDao.selectUserByName(userName);
            return user != null;
        } catch (Exception e) {
            LOGGER.error("Service: isUserExisted({}) error {}", userName, e);
            return false;
        }
    }

    public User getUserByName(String userName) {
        return pmsDao.selectUserByName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByName(username);
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
                return authenticatedUser.getName();
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
            return getUserByName(auth.getName());
        }
        return null;
    }
}

