package com.baomidou.samples.druid.mybatis.service.message;

import com.baomidou.samples.druid.mybatis.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author junfeng.hu
 * @create 2020-02-12 16:33
 */
public class ZentaoUserServiceTest extends TestBase {

    @Autowired
    ZentaoUserService zentaoUserService;

    @Test
    public void queryUsers() {
        zentaoUserService.queryUsers("11");
    }
}