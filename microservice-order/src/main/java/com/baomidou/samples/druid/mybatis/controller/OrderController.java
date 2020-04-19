package com.baomidou.samples.druid.mybatis.controller;

import com.baomidou.samples.druid.mybatis.structrue.CallResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {

    @RequestMapping(value="/order/getOrderById", method={RequestMethod.GET})
    public CallResult query() throws Exception {
        log.info("订单微服务");
        int a = 60/0;
        return CallResult.success("订单微服务");
    }














}

