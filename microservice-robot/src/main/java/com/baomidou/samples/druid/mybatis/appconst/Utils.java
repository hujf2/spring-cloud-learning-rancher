package com.baomidou.samples.druid.mybatis.appconst;

import com.mapabc.springboot.common.log.LogBeanBuilders;
import com.mapabc.springboot.common.log.LoggerLogcenterUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author junfeng.hu
 * @create 2019-11-16 0:40
 */
public class Utils {
    public static String getTypeFromList(String TURNTYPE){
        if(TURNTYPE.contains(",")){
            TURNTYPE = TURNTYPE.split(",")[0];
            return TURNTYPE;
        }
        return TURNTYPE;
    }

    public static String getToday(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return df.format(date);
    }


}
