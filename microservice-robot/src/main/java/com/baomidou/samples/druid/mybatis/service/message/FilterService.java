package com.baomidou.samples.druid.mybatis.service.message;


import com.baomidou.samples.druid.mybatis.appconst.Utils;
import com.baomidou.samples.druid.mybatis.entity.mysql.ZentaoTask;
import com.baomidou.samples.druid.mybatis.entity.mysql.ZentaoUser;
import com.mapabc.springboot.common.log.LogBeanBuilders;
import com.mapabc.springboot.common.log.LoggerLogcenterUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author junfeng.hu
 * @create 2018-11-21 15:38
 */

@RefreshScope
@Service
public class FilterService {

    @Autowired
    ZentaoPushConfigService zentaoPushConfigService;

    @Autowired
    @Qualifier("holiday")
    private List<String> holiday;

    @Autowired
    @Qualifier("salesDepartment")
    private List<String> salesDepartment;

    @Autowired
    @Qualifier("skip")
    private List<String> skip;

    @Autowired
    @Qualifier("systemPushMessage")
    private List<String> systemPushMessage;


    @Autowired
    @Qualifier("systemPushWebhook")
    private List<String> systemPushWebhook;

    @SuppressWarnings("all")
    @Autowired
    ZentaoTaskService zentaoTaskService;

    public  boolean isHolidays () {
        Date dNow = new Date();   //当前时间
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
        dBefore = calendar.getTime();   //得到前一天的时间

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
        String defaultStartDate = sdf.format(dBefore);    //格式化前一天
        String defaultEndDate = sdf.format(dNow); //格式化当前时间
        System.out.println("defaultStartDate = " + defaultStartDate);
        //判决今天是不是假期
        if(holiday.contains(defaultEndDate)) {
            return true;
        }
        //不是假期
        return false;
    }

    public  void getSaleList(ArrayList<ArrayList<String>> pushList ){

        ArrayList<String> finSalesDepartmentList = new ArrayList<>();

        for (int i = 0; i < salesDepartment.size(); i++) {
            String mobile = salesDepartment.get(i);
            boolean isSkip = skip.contains(mobile);
            //如果在跳过表，则跳过
            if(isSkip) {
                continue;
            }

            ZentaoUser zentaoUser = zentaoTaskService.queryTasks(mobile);

            //按照电话号码查询你， 没有找到这个人， 理论上不应该啊
            if(zentaoUser==null){
                System.out.println("按照电话号码查询你， 没有找到这个人， 理论上不应该啊 ==》" + zentaoUser);
                continue;
            }

            List<ZentaoTask> rs = zentaoTaskService.queryTasks(zentaoUser.getAccount(), Utils.getToday());

            System.out.println("zentaoUser = " + zentaoUser);
            System.out.println("zentaoUser.getAccount() = " + zentaoUser.getAccount());
            System.out.println("Utils.getToday() = " + Utils.getToday());
            //表示这个人没有填写任务

            if (!zentaoPushConfigService.goodConsumed(rs)) {
                finSalesDepartmentList.add(mobile);
            }
        }
        pushList.add(finSalesDepartmentList);
        return ;
    }


    public String getMessageByIndex(int i){
        return systemPushMessage.get(i);
    }

    public  boolean isExistInSalesDept(String moblies){
        return salesDepartment.contains(moblies);
    }

    public  boolean isExistInSkipList(String moblies){
        return skip.contains(moblies);
    }

    public String getWebhookByIndex(int i){
        return systemPushWebhook.get(i);
    }


    public void print(){
        for (int i = 0; i < salesDepartment.size(); i++) {
            System.out.println("i = " + i);
        }
    }
}
