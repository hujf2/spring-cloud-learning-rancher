package com.tengge.dubbo.service;

import com.tengge.dubbo.model.User;

/**
 * @author junfeng.hu
 * @create 2020-04-06 10:32
 */
public interface IUserService {
    public User getUserById(long id);
}
