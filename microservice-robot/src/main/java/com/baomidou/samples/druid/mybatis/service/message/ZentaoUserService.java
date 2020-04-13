package com.baomidou.samples.druid.mybatis.service.message;

import com.baomidou.samples.druid.mybatis.appconst.AppConst;
import com.baomidou.samples.druid.mybatis.appconst.StateTurnEnum;
import com.baomidou.samples.druid.mybatis.appconst.Utils;
import com.baomidou.samples.druid.mybatis.entity.mysql.ZentaoUser;
import com.baomidou.samples.druid.mybatis.mapper.ZentaoUserMapper;
import com.baomidou.samples.druid.mybatis.utils.IdGenerator;
import com.mapabc.springboot.common.log.LogBeanBuilders;
import com.mapabc.springboot.common.log.LoggerLogcenterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author junfeng.hu
 * @create 2019-11-12 23:02
 */
@Service
public class ZentaoUserService {

    @SuppressWarnings("all")
    @Autowired
    ZentaoUserMapper zentaoUserMapper;


    //cross 入库
    public List<ZentaoUser> queryUsers(String id) {
        return zentaoUserMapper.select(id);
    }


}