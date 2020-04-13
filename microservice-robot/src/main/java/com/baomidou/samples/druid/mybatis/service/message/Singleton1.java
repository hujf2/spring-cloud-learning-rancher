package com.baomidou.samples.druid.mybatis.service.message;

import io.micrometer.shaded.org.pcollections.HashPMap;

import java.util.HashMap;

public class Singleton1 {

    private static Singleton1 instance = null;

    private HashMap<String,Integer> redis = new HashMap<String,Integer>() ;

    public HashMap<String, Integer> getRedis() {
        return redis;
    }

    public void setRedis(HashMap<String, Integer> redis) {
        this.redis = redis;
    }

    private Singleton1() {
    }

    /**
     * 1、适用于单线程环境（不推荐）
     */
    public static Singleton1 getInstanceA() {
        if (null == instance) {
            instance = new Singleton1();
        }
        return instance;
    }
}