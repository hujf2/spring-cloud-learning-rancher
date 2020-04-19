package com.baomidou.samples.druid.mybatis.controller.ordercall;

import com.baomidou.samples.druid.mybatis.controller.FallbackRemoteClient;
import com.baomidou.samples.druid.mybatis.structrue.CallResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auther: hjf
 * @date: 2019/7/10 16:01
 * @description:
 */
@FeignClient(name = "microservice-prod", fallback = FallbackRemoteClientGood.class)
public interface RemoteClientGood {

    @GetMapping("/good/getGoodById")
//    @GetMapping("/good/getGoodById")
    CallResult getGood();

}

