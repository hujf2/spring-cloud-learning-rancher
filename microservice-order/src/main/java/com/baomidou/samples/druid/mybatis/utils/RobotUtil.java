package com.baomidou.samples.druid.mybatis.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: victor
 * Date: 13-9-26
 * Time: 上午10:03
 */
public class RobotUtil {

    private final static String screen = "screen";
    private final static String moveMouse = "moveMouse";
    private final static String doubleMouseClick = "doubleMouseClick";
    private final static String mouseClick = "mouseClick";
    private final static String rightClick = "rightClick";
    private final static String esc = "esc";
    private final static String selectAll = "selectAll";
    private final static String copy = "copy";
    private final static String paste = "paste";
    private final static String delete = "delete";
    private final static String mouseWheel = "mouseWheel";
    private final static String F10 = "F10";

    private Robot robot;


    public static void main(String[] args) throws Exception {
        RobotUtil robotUtil = new RobotUtil(new Robot());
        robotUtil.getRobot().setAutoDelay(50);

        Thread.sleep(5000);

        List<String> list = new ArrayList();
//        list.add("moveMouse,953,672");
//        list.add("doubleMouseClick,0,0");
//        list.add("mouseClick,0,0");
//        list.add("selectAll,0,0");
//        list.add("copy,0,0");
//        list.add("moveMouse,565,1056");
//        list.add("mouseClick,0,0");
//        list.add("moveMouse,286,283");
//        list.add("mouseClick,0,0");
        list.add("F10,0,0");

        for (String command : list){
            String[] splitCmd = command.split(",");
            String cmd = splitCmd[0];
            String x = splitCmd[1];
            String y = splitCmd[2];
            robotUtil.action(cmd, x, y);
        }
    }




    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public RobotUtil(Robot robot) {
        this.robot = robot;
    }

    public void screen()  {

        try {
            //设置Robot产生一个动作后的休眠时间,否则执行过快
            robot.setAutoDelay(1000);

            //获取屏幕分辨率
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            System.out.println(d);
            //以屏幕的尺寸创建个矩形
            Rectangle screenRect = new Rectangle(d);
            //截图（截取整个屏幕图片）
            BufferedImage bufferedImage = robot.createScreenCapture(screenRect);
            //保存截图
            LocalDateTime local = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");

            File file = new File(formatter.format(local) + " screenRect.png");
            ImageIO.write(bufferedImage, "png", file);

        }  catch (Exception e) {
            e.printStackTrace();
        }


    }

    //移动鼠标
    public void moveMouse(int x, int y) {
        System.out.println("鼠標坐標 x  = " + x + " y = " + y);
        robot.mouseMove(x, y);
    }

    //点击鼠标
    //鼠标左键
    public void mouseClick() {
        System.out.println("单击");
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void doubleMouseClick() {
       for (int i=0; i<2; i++)
           mouseClick();
    }

    //点击鼠标
    //鼠标左键
    public void  rightClick () {
        //鼠标右键
        System.out.println("右击");
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    //按下ESC，退出右键状态
    public void  esc () {
        System.out.println("按下ESC");
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    //按下全選
    public void  selectAll () {
        System.out.println("按下ESC");
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    //按下複製
    public void  copy () {
        System.out.println("複製");
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    //按下粘貼
    public void  paste () {
        System.out.println("按下");
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    //按下刪除
    public void  delete () {
        System.out.println("按下");
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
    }
    //按下F10
    public void  F10 () {
        System.out.println("按下F10");
        robot.keyPress(KeyEvent.VK_F10);
        robot.keyRelease(KeyEvent.VK_F10);
    }

    //滚轴
    public void  mouseWheel () {
        System.out.println("滚轴");
        robot.mouseWheel(5);
    }


    public void action(String cmd, String x, String y){
        action( cmd,  Integer.parseInt(x),  Integer.parseInt(y));
    }

    public void action(String cmd, int x, int y){
        if(screen.equals(cmd)) {
            screen();
        }

        if(moveMouse.equals(cmd)) {
            moveMouse(x, y);
        }

        if(mouseClick.equals(cmd)) {
            mouseClick();
        }

        if(rightClick.equals(cmd)) {
            rightClick();
        }

        if(esc.equals(cmd)) {
            esc();
        }

        if(selectAll.equals(cmd)) {
            selectAll();
        }

        if(copy.equals(cmd)) {
            copy();
        }

        if(paste.equals(cmd)) {
            paste();
        }

        if(delete.equals(cmd)) {
            delete();
        }

        if(mouseWheel.equals(cmd)) {
            mouseWheel();
        }

        if(doubleMouseClick.equals(cmd)) {
            doubleMouseClick();
        }

        if(F10.equals(cmd)) {
            F10();
        }


    }


}