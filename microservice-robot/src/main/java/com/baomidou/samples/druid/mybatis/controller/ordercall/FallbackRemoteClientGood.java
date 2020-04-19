package com.baomidou.samples.druid.mybatis.controller.ordercall;

import com.baomidou.samples.druid.mybatis.controller.RemoteClient;
import com.baomidou.samples.druid.mybatis.structrue.CallResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @auther: hjf
 * @date: 2019/7/10 16:01
 * @description:
 */
@Slf4j
@Component
public class FallbackRemoteClientGood implements RemoteClientGood{

   @Override
   public CallResult getGood(){
        log.info("调用 商品 微服务失败，记录一条日志入库, 用于将来补偿");
        return CallResult.failure("调用 商品 微服务失败，记录一条日志入库, 用于将来补偿");
   }

}

