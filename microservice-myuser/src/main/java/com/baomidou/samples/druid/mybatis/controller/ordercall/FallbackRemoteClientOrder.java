package com.baomidou.samples.druid.mybatis.controller.ordercall;

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
public class FallbackRemoteClientOrder implements RemoteClientOrder{

   @Override
   public CallResult getGood(){
        log.info("myuser 调用 order微服务失败");
        return CallResult.failure("myuser 调用 order微服务失败");
   }

}

