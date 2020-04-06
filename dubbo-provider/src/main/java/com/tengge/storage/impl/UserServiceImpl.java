package com.tengge.storage.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tengge.dubbo.model.User;
import com.tengge.dubbo.service.IUserService;
import org.springframework.stereotype.Component;

/**
 * Created by zhaoyh on 2018/3/20
 * @author zhaoyh
 */
@Service(version = "1.0")
public class UserServiceImpl implements IUserService {

    @Override
    public User getUserById(long id) {
        return new User(1, "zhaoyh", 26);
    }
}