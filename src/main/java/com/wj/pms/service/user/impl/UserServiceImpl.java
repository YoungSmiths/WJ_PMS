package com.wj.pms.service.user.impl;

import com.wj.pms.common.mapper.UserInfoMapper;
import com.wj.pms.common.model.UserInfo;
import com.wj.pms.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userMapper;//这里会报错，但是并不会影响

    public UserInfo get(){
       return  userMapper.selectByPrimaryKey(1111);
    }
}
