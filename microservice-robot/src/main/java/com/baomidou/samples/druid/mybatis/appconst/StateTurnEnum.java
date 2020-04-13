package com.baomidou.samples.druid.mybatis.appconst;

public enum StateTurnEnum {
//    右转	r
//    向左合并	1
//    左转	l
//    掉头	u
//    直行	s

//    1:左转 2：直行 3：右转 4：掉头

    ZZ("1","l","左转"),
    ZX("2","s","直行"),
    YZ("3","r","右转"),
    DT("4","u","掉头");

    private String turnCode;
    private String turnEn ;
    private String turnName ;

    StateTurnEnum(String turnCode, String turnEn, String turnName) {
        this.turnCode = turnCode;
        this.turnEn = turnEn;
        this.turnName = turnName;
    }

    public String getTurnCode() {
        return turnCode;
    }

    public void setTurnCode(String turnCode) {
        this.turnCode = turnCode;
    }

    public String getTurnEn() {
        return turnEn;
    }

    public void setTurnEn(String turnEn) {
        this.turnEn = turnEn;
    }

    public String getTurnName() {
        return turnName;
    }

    public void setTurnName(String turnName) {
        this.turnName = turnName;
    }
}