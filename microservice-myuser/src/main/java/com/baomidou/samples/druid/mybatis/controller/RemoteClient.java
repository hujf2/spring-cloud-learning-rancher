package com.baomidou.samples.druid.mybatis.controller;

import com.baomidou.samples.druid.mybatis.entity.dingding.ZentaoMessageEntity;
import com.baomidou.samples.druid.mybatis.structrue.CallResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @auther: hjf
 * @date: 2019/7/10 16:01
 * @description:
 */
@FeignClient(name = "microservice-order", fallback = FallbackRemoteClient.class)
public interface RemoteClient {

    @GetMapping("/order/getOrderById")
//    @GetMapping("/good/getGoodById")
    CallResult getGood();

}

