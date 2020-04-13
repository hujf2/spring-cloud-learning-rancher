package com.baomidou.samples.druid.mybatis.cron;

import com.baomidou.samples.druid.mybatis.service.message.JsoupService;
import com.baomidou.samples.druid.mybatis.service.message.JsoupServiceLive;
import com.baomidou.samples.druid.mybatis.service.message.MonitorService;
import com.baomidou.samples.druid.mybatis.service.message.ZentaoPushService;
import com.mapabc.springboot.common.log.LogBeanBuilders;
import com.mapabc.springboot.common.log.LoggerLogcenterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configurable
@EnableScheduling
public class ScheduledTasks {

    private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    MonitorService monitorService;

    @Autowired
    JsoupService jsoupService;


    @Autowired
    JsoupServiceLive jsoupServiceLive;

    // 普通群发
//    @Scheduled(fixedDelay = 1000*60*2)
//    public void reportCurrentByCron(){
//       try {
//           logger.info("定时任务执行。。。");
//           jsoupService.control();
//       }catch (Exception e){
//           e.printStackTrace();
//       }
//    }

    //万群直播
    @Scheduled(fixedDelay = 1000*60*3)
    public void reportCurrentByCronLive(){
        try {
          logger.info("定时任务是50秒启动一次。。。");
          jsoupServiceLive.control();
        }catch (Exception e){
            e.printStackTrace();
        }
    }







}