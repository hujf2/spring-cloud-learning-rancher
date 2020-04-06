package com.cott.gmail.bootorderserviceconsumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cott.gmail.bean.UserAddress;
import com.cott.gmail.service.OrderService;
import com.cott.gmail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Reference
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String id) {
        System.out.println("id= " + id);
        List<UserAddress> list = userService.getAddress("1");
        for (UserAddress user : list
        ) {
            System.out.println(user.getUserAddress());
        }
        return list;
    }
}