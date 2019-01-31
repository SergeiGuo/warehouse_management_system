package com.wms.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.user.pojo.User;

import java.util.List;

/**
 * description:
 * Author:Childwanwan
 * Date:2019/1/16 19:14
 */
public interface UserService extends IService<User> {
    public User queryAllUser();

    public List<User> queryUserByTelAndPasswordAndStatus(String tel,String password,int status);
}
