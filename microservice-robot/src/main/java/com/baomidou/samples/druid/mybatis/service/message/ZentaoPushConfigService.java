package com.baomidou.samples.druid.mybatis.service.message;

import com.alibaba.fastjson.JSON;
import com.baomidou.samples.druid.mybatis.appconst.Utils;
import com.baomidou.samples.druid.mybatis.controller.RemoteClient;
import com.baomidou.samples.druid.mybatis.entity.dingding.DingdingMsgModel;
import com.baomidou.samples.druid.mybatis.entity.dingding.DingdingMsgModel.AtBean;
import com.baomidou.samples.druid.mybatis.entity.dingding.DingdingMsgModel.TextBean;
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

import java.util.ArrayList;
import java.util.List;

/**
 * @author junfeng.hu
 * @create 2019-12-25 14:55
 */

@Service
public class ZentaoPushConfigService {

    public boolean goodConsumed(List<ZentaoTask> rs){

        try {
            //以下3种情况都at 这个人
            if(rs == null)
                return false;
            else if(rs.size() == 0)
                return false;
            else if(Float.parseFloat(rs.get(0).getConsumed()) != 8) {
                return false;
            }else {


            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //不需要at
        return true;
    }




}