package com.baomidou.samples.druid.mybatis.controller;

import com.baomidou.samples.druid.mybatis.entity.dingding.DingdingAlertModel;
import com.baomidou.samples.druid.mybatis.entity.dingding.ZentaoMessageEntity;
import com.baomidou.samples.druid.mybatis.structrue.CallResult;
import org.springframework.stereotype.Component;

@Component
public class RemoteHystrix implements RemoteClient {


    @Override
    public String helloNacos() {
        return "请求故障";
    }

    @Override
    public CallResult zentaoPush(ZentaoMessageEntity zentaoMessageEntity) {
        return CallResult.success("请求故障");
    }

    @Override
    public CallResult alertEvent(DingdingAlertModel dingdingAlertModel) {
        return CallResult.success("请求故障");
    }
}
