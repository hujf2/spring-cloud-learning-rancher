package com.baomidou.samples.druid.mybatis.service.message;

import com.alibaba.fastjson.JSON;
import com.baomidou.samples.druid.mybatis.appconst.Utils;
import com.baomidou.samples.druid.mybatis.controller.RemoteClient;
import com.baomidou.samples.druid.mybatis.entity.dingding.DingdingMsgModel;
import com.baomidou.samples.druid.mybatis.entity.dingding.DingdingMsgModel.TextBean;
import com.baomidou.samples.druid.mybatis.entity.dingding.DingdingMsgModel.AtBean;
import com.baomidou.samples.druid.mybatis.entity.dingding.ZentaoMessageEntity;
import com.baomidou.samples.druid.mybatis.entity.mysql.ZentaoTask;
import com.baomidou.samples.druid.mybatis.entity.mysql.ZentaoUser;
import com.mapabc.springboot.common.log.LogBeanBuilders;
import com.mapabc.springboot.common.log.LoggerLogcenterUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author junfeng.hu
 * @create 2019-12-25 14:55
 */

@RefreshScope
@Service
public class ZentaoPushService {

    @Autowired
    ZentaoPushConfigService zentaoPushConfigService;

    @Autowired
    FilterService filterService;

    @Autowired
    RemoteClient remoteClient;

    @Value(value = "${channel.zentao.dingding.maxAtNum:}")
    private int maxAtNum;

    @Autowired
    ZentaoUserService zentaoUserService;

    @Autowired
    ZentaoTaskService zentaoTaskService;

    ArrayList<ArrayList<String>> pushList = new ArrayList<>();

    ZentaoMessageEntity zentaoMessageEntity = new ZentaoMessageEntity();

    DingdingMsgModel dingdingMsgModel = new DingdingMsgModel();

    AtBean at = new AtBean();

    TextBean text = new TextBean();



    public void exec(){

        //是假期，保持静默， 不做任何推送
        if(filterService.isHolidays()) {
            System.out.println("今天是假期，不推送..." );
            return ;
        }
        //构建2个待发送的list
        buildDev("研发部");
        buildSales("销售部");

        for (int i = 0; i < pushList.size(); i++) {
            ArrayList mobiles = pushList.get(i);
            // 当i = 0 推研发部
            // 当i = 1 推销售部
            pushProcess(mobiles, i);
        }
        pushList.clear();
        return ;

    }

    private void buildDev(String name) {
        ArrayList<String> mobiles = new ArrayList<>();
        List<ZentaoUser> zentaoAccounts = zentaoUserService.queryUsers(null);
        for (ZentaoUser zentaoUser : zentaoAccounts) {
            List<ZentaoTask> rs = zentaoTaskService.queryTasks(zentaoUser.getAccount(), Utils.getToday());
            System.out.println("zentaoUser.getAccount() = " + zentaoUser.getAccount());
            System.out.println("Utils.getToday() = " + Utils.getToday());

            //如果rs.size == 0, 则 task 今天没有被操作的话， 就把电话号码加到推送列表里面
            if (!zentaoPushConfigService.goodConsumed(rs)) {
                //发钉钉
                if(!StringUtils.isEmpty(zentaoUser.getPhone())){
                    //检查是否在销售清单里面
                    boolean isExistInSales = filterService.isExistInSalesDept(zentaoUser.getPhone());
                    boolean isExistInSkip = filterService.isExistInSkipList(zentaoUser.getPhone());
                    if(!isExistInSales && !isExistInSkip) {
                        mobiles.add(zentaoUser.getPhone());
                    }
                }else {
                    LoggerLogcenterUtil.info(getClass(),new LogBeanBuilders().setAccessLog( "-->" + "这个人的电话为null~~" + zentaoUser.getAccount() ));
                }

            }
        }
        System.out.println("mobiles === " + mobiles);
        pushList.add(mobiles);
        return ;

    }


    private void buildSales(String name) {
        // 返回研发部的list
        filterService.getSaleList(pushList);
    }



    public void pushProcess(ArrayList<String> mobiles, int index){
        if(mobiles==null) return;
        if(mobiles.size()==0) return;

        ArrayList<ArrayList<String>> batchPush = new ArrayList();

        ArrayList<String> segmentList = new ArrayList();

        // 因为钉钉最大一次只可以@ 19个手机号码， 因此必须做分批发送的逻辑判断
        for(int i=0; i<mobiles.size(); i++) {
            segmentList.add(mobiles.get(i));
            if((i+1)%maxAtNum == 0) {
                buildMessageModel(segmentList,index);
                remoteClient.zentaoPush(zentaoMessageEntity);
                segmentList.clear();
                //处理正好是19个人的情况
                if(i == (mobiles.size() - 1)){
                    continue;
                }
            }
            if(i == (mobiles.size() - 1)){
                buildMessageModel(segmentList,index);
                remoteClient.zentaoPush(zentaoMessageEntity);
            }
        }



        return ;

    }


    public void buildMessageModel(ArrayList<String> mobiles, int index){
        at.setAtMobiles(mobiles);
        text.setContent(filterService.getMessageByIndex(index));

        dingdingMsgModel.setAt(at);
        dingdingMsgModel.setText(text);
        dingdingMsgModel.setMsgtype("text");
        String pushMsg = "";
        try {
            Thread.sleep(5);
            System.out.println("pushMsg ===> " + pushMsg);
            pushMsg = JSON.toJSONString(dingdingMsgModel);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("pushMsg ....> " + pushMsg);
        LoggerLogcenterUtil.info(getClass(),new LogBeanBuilders().setAccessLog("pushMsg = [{0}]", pushMsg ));
        zentaoMessageEntity.setJson(pushMsg);
        zentaoMessageEntity.setWebhook(filterService.getWebhookByIndex(index));
    }





}