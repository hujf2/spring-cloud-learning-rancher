package com.baomidou.samples.druid.mybatis.service.message;

import com.baomidou.samples.druid.mybatis.entity.mysql.ZentaoTask;
import com.baomidou.samples.druid.mybatis.entity.mysql.ZentaoUser;
import com.baomidou.samples.druid.mybatis.mapper.ZentaoTaskMapper;
import com.baomidou.samples.druid.mybatis.mapper.ZentaoUserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author junfeng.hu
 * @create 2019-11-12 23:02
 */
@Service
public class ZentaoTaskService {

    @SuppressWarnings("all")
    @Autowired
    ZentaoTaskMapper taskMapper;


    public List<ZentaoTask> queryTasks(String lastEditedBy, String lastEditedDate) {
        return taskMapper.select(lastEditedBy, lastEditedDate);
    }


    public ZentaoUser queryTasks(String phone) {
        return taskMapper.selectUserByPhone(phone);
    }

}