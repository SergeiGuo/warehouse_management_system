package com.wms.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wms.user.mapper.UserMapper;
import com.wms.user.pojo.User;
import com.wms.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 * Author:Childwanwan
 * Date:2019/1/16 19:16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    public User queryAllUser(){
        return userMapper.selectById("1");
    }
}
