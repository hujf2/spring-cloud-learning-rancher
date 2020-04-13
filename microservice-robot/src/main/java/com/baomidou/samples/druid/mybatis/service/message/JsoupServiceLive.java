package com.baomidou.samples.druid.mybatis.service.message;

import com.baomidou.samples.druid.mybatis.utils.ConstantVar;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//导入包

/**
 * @author junfeng.hu
 * @create 2020-04-08 19:28
 */
@Service
public class JsoupServiceLive {

    private Logger logger = LoggerFactory.getLogger(JsoupServiceLive.class);

       @Autowired
       RobotUtilService robotUtilService;

        public  Elements getElements(String url) throws IOException {
            List<String> list = new ArrayList<>();
//            Document document = Jsoup.connect("https://shimo.im/docs/x9rHqYRVdtRVW686").get();
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("p");
//            String line = Elements
            return elements;
        }


        public  String getText(String url) throws IOException {
            String line = getElements(url).text();
            return line;
        }

        public boolean checkIsExist(String url) throws Exception{

            String line = getText(url);

            String md5Key = DigestUtils.md5DigestAsHex(line.getBytes());
            if (Singleton1.getInstanceA().getRedis().get(md5Key) != null){
                logger.info("这条信息已经发布过：" + line );
                return true;
            }
            // 加入缓存
            Singleton1.getInstanceA().getRedis().put(md5Key, 1);
            return false;
        }


        public List<String> elementToList(String url) throws Exception{

            List<String> pageAsList = new ArrayList<>();

            Elements pageContext = getElements(url);
            for (Element element : pageContext){
                String smallLine = element.text();
                if( "".equals(smallLine) ) {
                    continue;
                }
                if( "[图片]".equals(smallLine) ) {
                    continue;
                }
                smallLine = smallLine.replaceAll(ConstantVar.regex, ConstantVar.replacement);
                pageAsList.add(smallLine.trim());
            }
            return pageAsList;
        }

        public List<List<String>> groupByList(String url) throws Exception {

            List<String> allText = elementToList(url);

            List<List<String>> contain = new ArrayList<>();

            //页面无数据
            if(allText==null || allText.size()==0){
                logger.info("页面无数据, url=" + url );
                return contain;
            }

            for (int i = 0; i < allText.size(); i++) {
                String line = allText.get(i);
                List<String> element = null;



                boolean isCreatedGroup = newCreatedGroup(line);

                //表示发送<p></p>中的片段，即为一段一段发送
                if(ConstantVar.pText.equals(line)){
                    postDiv(contain, allText);
                    break;
                }

                if(i==0) {
                    isCreatedGroup = initGroup(line);
                }

                if (isCreatedGroup) {
                    element = new ArrayList<>();
                    contain.add(element);
                    continue;
                }

                List<String> laststList = getLastElement(contain);
                laststList.add(line);

                contain.set(contain.size()-1, laststList);
            }
            //追加版权
            List<String> appendCopyright = getLastElement(contain);
            appendCopyright.add(ConstantVar.copyright);
            contain.set(contain.size()-1, appendCopyright);
           return contain;
        }

        public List<String> getLastElement(List<List<String>> contain){
            int lastElemenet = contain.size() - 1;
            List<String> groupList = contain.get(lastElemenet);
            return groupList;
        }

        public void control() throws Exception{
            appOnBootstrap();
        }

        //文本分组
        public void forGroupList(String url) throws Exception{
            List<List<String>> groupList = groupByList(url) ;

            for (List<String> group : groupList){

                List<String> fileContext = group;
                //写文件
                FileUtils.createFile(fileContext);
                //按下F10
                Thread.sleep(1000 * 5);

                logger.info("=========轮播 + 按下F10=========");
                robotUtilService.foo();

                //轮播一圈后进行睡眠一定时间
                Thread.sleep(1000 * 70 * 1);
            }

        }


    // 返回false ，说明没在直播
    // true，说明直播开关开启
    public boolean checkIsLive(String url) throws IOException {
        String textLive = getElements(url).text();
        if(ConstantVar.liveCtl.equals(textLive)){
            return false;
        }
        return true;
    }


        public void postDiv(List<List<String>> contain, List<String> allTextList){

            for (int i = 1; i < allTextList.size(); i++) {
                List<String> divList = new ArrayList<>();
                divList.add(allTextList.get(i));
                contain.add(divList);
            }

        }

        public void appOnBootstrap() throws Exception {
            //控制开关的URL
            String ctlUrl = ConstantVar.liveCtlPage;
            //内容页面的URL
            String contextUrl = ConstantVar.liveContextPage;

            boolean isLive = checkIsLive(ctlUrl);
            //万群直播开关开启的时候：isLive = true;
            if (!isLive){
                return;
            }

            //检测是否发布过
            boolean isPushlished = checkIsExist(contextUrl);
            //isPushlished=true， 说明已经发布过
            if (isPushlished){
                return;
            }
            //执行万群文字直播的业务逻辑
            logger.info("=========执行最外面的大循环=========");
            forGroupList(contextUrl);
        }


        public List<String> arrayAsList(){
            //准备一个String数组
            String[] strs = ConstantVar.getSpilitBy().split(ConstantVar.spilitByCharacter);
            //String数组转List
            List<String> list = Arrays.asList(strs);
            return list;
        }

        public boolean initGroup(String headLine){
            ConstantVar.setSpilitBy(headLine);
            return true;
        }

        public boolean newCreatedGroup(String line){
            List<String> strings = arrayAsList();
            //准备一个String数组
            for (int i = 0; i < strings.size(); i++) {
                if (line.startsWith(strings.get(i))){
                    return true;
                }
            }
            return false;
        }


}
