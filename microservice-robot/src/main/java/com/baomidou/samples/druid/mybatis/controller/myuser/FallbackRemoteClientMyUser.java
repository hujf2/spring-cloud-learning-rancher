package com.baomidou.samples.druid.mybatis.controller.myuser;

import com.baomidou.samples.druid.mybatis.controller.ordercall.RemoteClientGood;
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
public class FallbackRemoteClientMyUser implements RemoteClientMyUser{

   @Override
   public CallResult getGood(){
        log.info("调用myuser 失败");
        return CallResult.failure("调用myuser 失败");
   }

}

