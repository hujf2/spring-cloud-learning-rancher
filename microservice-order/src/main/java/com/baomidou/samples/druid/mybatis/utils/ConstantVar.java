package com.baomidou.samples.druid.mybatis.utils;

/**
 * @author junfeng.hu
 * @create 2020-04-11 14:56
 */
public class ConstantVar {
    public static final String flagCtl = "no";
    //默认状态，没有直播
    public static final String liveCtl = "no";
    public static final String ctlPage = "https://shimo.im/docs/CvVj9Rk8qc8k96Tv/";
    public static final String liveCtlPage = "https://shimo.im/docs/x8WvdQjwGtGthxpQ/";
    public static final String contextPage = "https://shimo.im/docs/x9rHqYRVdtRVW686/";
//    public static final String liveContextPage = "https://shimo.im/docs/Tp9CJRQXRKTcYGtr/";
    public static final String liveContextPage = "https://shimo.im/docs/Hr9PqgjkXYH9HDD8/";
    public static final String localPath = "C:\\Users\\elnvo\\Desktop\\动态文本.txt";
    public static final String regex = "灯塔君";
    public static final String replacement = "腾哥";
    public static final String pText = "p";
    //默认表头
    public static String spilitBy = "堂萌萌 @网易:";
    //支持多个分享嘉宾，用中文逗号“，”进行分割
    public static final String spilitByCharacter = "，";
    public static final String copyright = "(该分享来自公众号 | beijing-tmt | 架构师智库)";

    public static String getSpilitBy() {
        return spilitBy;
    }

    public static void setSpilitBy(String spilitBy) {
        ConstantVar.spilitBy = spilitBy;
    }
}
