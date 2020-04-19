package com.baomidou.samples.druid.mybatis.controller.myuser;

import com.baomidou.samples.druid.mybatis.controller.ordercall.FallbackRemoteClientGood;
import com.baomidou.samples.druid.mybatis.structrue.CallResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auther: hjf
 * @date: 2019/7/10 16:01
 * @description:
 */
@FeignClient(name = "microservice-myuser", fallback = FallbackRemoteClientMyUser.class)
public interface RemoteClientMyUser {

    @GetMapping("/my/myUserContrller")
//    @GetMapping("/good/getGoodById")
    CallResult getGood();

}

