package com.cott.gmail.service;

import com.cott.gmail.bean.UserAddress;

import java.util.List;

public interface OrderService {

    List<UserAddress> initOrder(String id);
}
