package com.baomidou.samples.druid.mybatis.service.message;

import com.baomidou.samples.druid.mybatis.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author junfeng.hu
 * @create 2020-04-08 20:54
 */
public class JsoupServiceTest extends TestBase {

    @Autowired
    JsoupService jsoupService;

    @Test
    public void control() throws Exception {
        jsoupService.get();
    }

    @Test
    public void get() {
    }
}