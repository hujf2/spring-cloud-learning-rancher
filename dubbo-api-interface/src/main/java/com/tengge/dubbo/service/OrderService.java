package com.tengge.dubbo.service;

import com.tengge.dubbo.model.User;

import java.util.List;

public interface OrderService {
    public List<User> initOrder(long id) ;
}