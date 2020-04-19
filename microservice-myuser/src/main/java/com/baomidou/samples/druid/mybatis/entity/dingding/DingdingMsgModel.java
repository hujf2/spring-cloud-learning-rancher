package com.baomidou.samples.druid.mybatis.entity.dingding;

import java.util.List;

/**
 * @author junfeng.hu
 * @create 2019-05-13 20:57
 */
public class DingdingMsgModel {

    /**
     * msgtype : text
     * text : {"content":"告警:Alarm{pkId=42, alarmName='测试警报888', dbName='string', clumName='pkid', tlbName='tlbname', periodTime=600, optSymbol='EQ', stateful=1, threshold=6, createTime=null, updateTime=null, note=Note{pkId=42, alarmId=42, noteName='钉钉警报', noteBody='600 秒内获取到的数据等于6', sendUrl='www.baidu.com', createTime=Mon May 13 20:49:27 CST 2019, updateTime=Mon May 13 20:49:27 CST 2019}}  @13910056241"}
     * at : {"atMobiles":["13910056241"],"isAtAll":false}
     */

    private String msgtype;
    private TextBean text;
    private AtBean at;

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public TextBean getText() {
        return text;
    }

    public void setText(TextBean text) {
        this.text = text;
    }

    public AtBean getAt() {
        return at;
    }

    public void setAt(AtBean at) {
        this.at = at;
    }

    public static class TextBean {
        /**
         * content : 告警:Alarm{pkId=42, alarmName='测试警报888', dbName='string', clumName='pkid', tlbName='tlbname', periodTime=600, optSymbol='EQ', stateful=1, threshold=6, createTime=null, updateTime=null, note=Note{pkId=42, alarmId=42, noteName='钉钉警报', noteBody='600 秒内获取到的数据等于6', sendUrl='www.baidu.com', createTime=Mon May 13 20:49:27 CST 2019, updateTime=Mon May 13 20:49:27 CST 2019}}  @13910056241
         */

        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public static class AtBean {
        /**
         * atMobiles : ["13910056241"]
         * isAtAll : false
         */

        private boolean isAtAll;
        private List<String> atMobiles;

        public boolean isIsAtAll() {
            return isAtAll;
        }

        public void setIsAtAll(boolean isAtAll) {
            this.isAtAll = isAtAll;
        }

        public List<String> getAtMobiles() {
            return atMobiles;
        }

        public void setAtMobiles(List<String> atMobiles) {
            this.atMobiles = atMobiles;
        }
    }
}
