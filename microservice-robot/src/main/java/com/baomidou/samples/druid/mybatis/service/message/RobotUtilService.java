package com.baomidou.samples.druid.mybatis.service.message;

import com.baomidou.samples.druid.mybatis.utils.RobotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* Created with IntelliJ IDEA.
* User: victor
* Date: 13-9-26
* Time: 上午10:03
*/
@Service
public class RobotUtilService
{

    public void foo() throws Exception{
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
    }

}