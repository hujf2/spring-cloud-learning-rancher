package com.baomidou.samples.druid.mybatis.appconst;

/**
 * @author junfeng.hu
 * @create 2019-11-28 11:04
 */
public enum ENUMFAILURETYPE {
    DB("数据库问题", 0),
    BACKEND("后台接口", 1),
    FRONTEND("前端应用", 2),
    CALC("数据流源头有问题", 3),
    SRC("前端应用", 4),
    SRV("服务接口有问题", 5),
    NET("网络不通", 6),
    NON("未知", -1);
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private ENUMFAILURETYPE(String name, int index) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(int index) {
        for (ENUMFAILURETYPE c : ENUMFAILURETYPE.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
