package com.baomidou.samples.druid.mybatis.appconst;

public enum StateFlagEnum {
    //sxtlx 字段 高精团队字典：   1 ： 枪机   2： 球机
    //type  字段 设施设备库字典： 01 球机  02 枪机 03 制高点 99 其他'
    Qiangji("高精数据库","枪机", "1", "设施设备库","枪机", "02"),
    Qiuji("高精数据库","球机", "2", "设施设备库","球机", "01");



    private String src;
    private String srcDeviceType ;
    private String srcDeviceCode ;
    private String target;
    private String targetDeviceType ;
    private String targetDeviceCode ;

    StateFlagEnum(String src, String srcDeviceType, String srcDeviceCode, String target, String targetDeviceType, String targetDeviceCode) {
        this.src = src;
        this.srcDeviceType = srcDeviceType;
        this.srcDeviceCode = srcDeviceCode;
        this.target = target;
        this.targetDeviceType = targetDeviceType;
        this.targetDeviceCode = targetDeviceCode;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getSrcDeviceType() {
        return srcDeviceType;
    }

    public void setSrcDeviceType(String srcDeviceType) {
        this.srcDeviceType = srcDeviceType;
    }

    public String getSrcDeviceCode() {
        return srcDeviceCode;
    }

    public void setSrcDeviceCode(String srcDeviceCode) {
        this.srcDeviceCode = srcDeviceCode;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTargetDeviceType() {
        return targetDeviceType;
    }

    public void setTargetDeviceType(String targetDeviceType) {
        this.targetDeviceType = targetDeviceType;
    }

    public String getTargetDeviceCode() {
        return targetDeviceCode;
    }

    public void setTargetDeviceCode(String targetDeviceCode) {
        this.targetDeviceCode = targetDeviceCode;
    }
}