package com.baomidou.samples.druid.mybatis.service.message;


import com.alibaba.fastjson.JSON;
import com.baomidou.samples.druid.mybatis.appconst.ENUMFAILURETYPE;
import com.baomidou.samples.druid.mybatis.entity.dingding.DingdingAlertModel;
import com.baomidou.samples.druid.mybatis.entity.dingding.DingdingMsgModel;
import com.baomidou.samples.druid.mybatis.entity.dingding.DingdingMsgModel.AtBean;
import com.baomidou.samples.druid.mybatis.entity.dingding.DingdingMsgModel.TextBean;
import com.mapabc.springboot.common.log.LogBeanBuilders;
import com.mapabc.springboot.common.log.LoggerLogcenterUtil;
import lombok.Data;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author junfeng.hu
 * @create 2018-11-21 15:38
 */

@Service
public class MonitorService {

    @Autowired
    RestTemplate restTemplate;

//    @SuppressWarnings("all")
//    @Autowired
//    private DingdingMessageClient remoteClient;

    public void curlService(){
        ResponseEntity<String> responseEntity = null;
        String eMessage = null;
        try {
            responseEntity = restTemplate.exchange("http://114.215.47.93:8040/eventapi/get", HttpMethod.GET, null, String.class);
        }catch (Exception e){
            eMessage = e.getMessage();
            LoggerLogcenterUtil.info(getClass(),new LogBeanBuilders()
                               .setAccessLog("服务端故障: [{0}]  应用名称: [{1}]", responseEntity,"microservice-event"));
        }

        LoggerLogcenterUtil.info(getClass(),new LogBeanBuilders()
                .setAccessLog("服务端返回: [{0}]  应用名称: [{1}]", responseEntity,"microservice-event"));


        if(responseEntity != null && responseEntity.getStatusCode().value()==200){
             //正常,什么也不用做
            System.out.println(" 应用正常 " );
            LoggerLogcenterUtil.info(getClass(),new LogBeanBuilders()
              .setAccessLog("应用是否正常: [{0}]  应用名称: [{1}]", "是","microservice-event"));

        }else{

            DingdingAlertModel dingdingAlertModel = new DingdingAlertModel();
            dingdingAlertModel.setSign("f479e0977b1cebc837bc2b2ad1a2d3fd");
            ArrayList<String> note = new ArrayList<>();
            note.add("接口名称:http://114.215.47.93:8040/eventapi/eventservice ");
            note.add("协议:http");
            note.add("错误信息:"+eMessage);
            dingdingAlertModel.setNote(note);
            dingdingAlertModel.setFailureType(ENUMFAILURETYPE.NET.getIndex());
            //可以指定额外的手机号码
//            dingdingAlertModel.setAtMobile("13912341234");
            dingdingAlertModel.setFailureTime(String.valueOf(new Date().getTime()/1000));
            dingdingAlertModel.setAppName("高德事件回流服务");
            dingdingAlertModel.setArtifactId("microservice-event");
//            remoteClient.curl(dingdingAlertModel);

            // 调用发送钉钉的接口
            LoggerLogcenterUtil.info(getClass(),new LogBeanBuilders()
                    .setAccessLog("发送钉钉: {0}  应用名称: {1}", dingdingAlertModel,"microservice-event"));

        }

    }
}
