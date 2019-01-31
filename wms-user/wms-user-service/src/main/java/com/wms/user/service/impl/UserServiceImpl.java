package com.wms.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wms.user.mapper.UserMapper;
import com.wms.user.pojo.User;
import com.wms.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @Override
    public List<User> queryUserByTelAndPasswordAndStatus(String tel,String password,int status) {
        //4. 通过Map封装条件查询
	Map<String,Object> columnMap = new HashMap<>();
	columnMap.put("telephone", tel);
	columnMap.put("password", password);
	columnMap.put("status",status);

	List<User> users = userMapper.selectByMap(columnMap);
	//System.out.println(users);
        return users;
    }
}
