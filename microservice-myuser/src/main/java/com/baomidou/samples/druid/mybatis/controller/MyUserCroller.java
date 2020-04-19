package com.baomidou.samples.druid.mybatis.controller;

import com.baomidou.samples.druid.mybatis.controller.ordercall.RemoteClientOrder;
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
    RemoteClientOrder remoteClientOrder;




    @RequestMapping(value="/callorder", method={RequestMethod.GET})
    public CallResult query2() throws Exception {
        System.out.println(" ...... call 。。。。 " );
        return CallResult.success(remoteClientOrder.getGood());
    }


}

