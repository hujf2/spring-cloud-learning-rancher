package com.baomidou.samples.druid.mybatis.controller;

import com.baomidou.samples.druid.mybatis.structrue.CallResult;
import jdk.nashorn.internal.codegen.CompilerConstants;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auther: hjf
 * @date: 2019/7/10 16:01
 * @description:
 */
@Slf4j
@Component
public class FallbackRemoteClient implements RemoteClient{

   @Override
   public CallResult getGood(){
        log.info("调用 订单 微服务失败，记录一条日志入库, 用于将来补偿");
        return CallResult.failure("调用 定单 微服务失败，记录一条日志入库, 用于将来补偿");
   }

}

