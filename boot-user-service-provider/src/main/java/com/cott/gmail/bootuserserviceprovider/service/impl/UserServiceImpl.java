package com.cott.gmail.bootuserserviceprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cott.gmail.bean.UserAddress;
import com.cott.gmail.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {

    @Override
    public List<UserAddress> getAddress(String uesrId) {
        UserAddress userAddress1 = new UserAddress();
        userAddress1.setId(100);
        userAddress1.setUserAddress("1001");
        userAddress1.setUserId("1000");
        UserAddress userAddress2 = new UserAddress();
        userAddress2.setId(200);
        userAddress2.setUserAddress("2001");
        userAddress2.setUserId("2000");

        return Arrays.asList(userAddress1, userAddress2);
    }
}