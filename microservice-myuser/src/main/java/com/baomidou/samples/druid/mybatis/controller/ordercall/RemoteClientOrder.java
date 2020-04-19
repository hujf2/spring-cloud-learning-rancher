package com.baomidou.samples.druid.mybatis.controller.ordercall;

import com.baomidou.samples.druid.mybatis.structrue.CallResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auther: hjf
 * @date: 2019/7/10 16:01
 * @description:
 */
@FeignClient(name = "microservice-order", fallback = FallbackRemoteClientOrder.class)
public interface RemoteClientOrder {

    @GetMapping("/order/getOrderById")
    CallResult getGood();

}

