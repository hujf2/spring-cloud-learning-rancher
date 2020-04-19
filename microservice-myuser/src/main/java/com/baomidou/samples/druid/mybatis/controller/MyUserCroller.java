package com.baomidou.samples.druid.mybatis.controller;

import com.baomidou.samples.druid.mybatis.controller.ordercall.RemoteClientGood;
import com.baomidou.samples.druid.mybatis.service.message.JsoupService;
import com.baomidou.samples.druid.mybatis.structrue.CallResult;
import com.baomidou.samples.druid.mybatis.utils.RobotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RefreshScope
@RestController
public class MyUserCroller {


    @Autowired
    @Qualifier("skip")
    private List<String> skip;

    @Autowired
    JsoupService jsoupService;

    @SuppressWarnings("all")
    @Autowired
    RemoteClient remoteClient;


    @SuppressWarnings("all")
    @Autowired
    RemoteClientGood remoteClientGood;


    @RequestMapping(value="/queryGood", method={RequestMethod.GET})
    public CallResult query() throws Exception {
        System.out.println(" ...... call 。。。。 " );
        return CallResult.success(remoteClient.getGood());
    }

    @RequestMapping(value="/realQueryGood", method={RequestMethod.GET})
    public CallResult query2() throws Exception {
        System.out.println(" ...... call 。。。。 " );
        return CallResult.success(remoteClientGood.getGood());
    }



    @RequestMapping(value="/try0", method={RequestMethod.GET})
    public CallResult try0() throws Exception {
        for(String test:skip) {
            System.out.println("test ==> " + test);
        }

//        RobotUtilService.main2(null);
        return CallResult.success(new Date() );
    }

    @RequestMapping(value="/sayhello", method={RequestMethod.GET})
    public CallResult sayHello() throws Exception {
        return CallResult.success(new Date() );
    }


    @RequestMapping(value="/news", method={RequestMethod.GET})
    public CallResult writeNews() throws Exception {
        jsoupService.get();
        return CallResult.success(new Date() );
    }


    @RequestMapping(value="/f10", method={RequestMethod.GET})
    public CallResult f10Driver() throws Exception {

        RobotUtil robotUtil = new RobotUtil(new Robot());
        robotUtil.getRobot().setAutoDelay(50);

        Thread.sleep(5000);

        List<String> list = new ArrayList();

        list.add("F10,0,0");

        for (String command : list){
            String[] splitCmd = command.split(",");
            String cmd = splitCmd[0];
            String x = splitCmd[1];
            String y = splitCmd[2];
            robotUtil.action(cmd, x, y);
        }

        return CallResult.success(new Date() );
    }




    @RequestMapping(value="/my/myUserContrller", method={RequestMethod.GET})
    public CallResult myUserService() throws Exception {
        int bb = 55/0;
        System.out.println(" ...... 这里是myUserContrller。。。。 " );
        return CallResult.success(new Date());
    }







}

