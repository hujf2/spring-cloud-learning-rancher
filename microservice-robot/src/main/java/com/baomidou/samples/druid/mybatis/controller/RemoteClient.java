package com.baomidou.samples.druid.mybatis.controller;

import com.baomidou.samples.druid.mybatis.entity.dingding.DingdingAlertModel;
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
@FeignClient(name = "microservice-dingding",fallback = RemoteHystrix.class)
public interface RemoteClient {

    @GetMapping("/dingding-service/api/hello")
    String helloNacos();

    @PostMapping("/dingding-service/api/alert")
    CallResult alertEvent(DingdingAlertModel dingdingAlertModel);

    @PostMapping("/dingding-service/api/zentao/alert")
    CallResult zentaoPush(ZentaoMessageEntity zentaoMessageEntity);
}

