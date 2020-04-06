package com.cott.gmail.service;

import com.cott.gmail.bean.UserAddress;

import java.util.List;

public interface UserService {
    List<UserAddress> getAddress(String userId);
}