package com.baomidou.samples.druid.mybatis.controller;

import com.baomidou.samples.druid.mybatis.DemoMetrics;
import com.baomidou.samples.druid.mybatis.service.message.*;
import com.baomidou.samples.druid.mybatis.structrue.CallResult;
import com.baomidou.samples.druid.mybatis.utils.RobotUtil;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class FeignController {

    @Autowired
    CollectorService collectorService;

    @Autowired
    DemoMetrics demoMetrics;

    @Autowired
    @Qualifier("skip")
    private List<String> skip;

    @Autowired
    JsoupService jsoupService;

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



    @RequestMapping(value="/try1", method={RequestMethod.GET})
    public CallResult testProme() throws Exception {
        demoMetrics.getMyCounter().increment(100);
        return CallResult.success(new Date() );
    }

    @RequestMapping(value="/try2", method={RequestMethod.GET})
    public CallResult try2() throws Exception {
        demoMetrics.myGauge.addAndGet(10);
        return CallResult.success(new Date() );
    }


}

