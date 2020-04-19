package com.baomidou.samples.druid.mybatis.service.message;

import com.baomidou.samples.druid.mybatis.cron.ScheduledTasks;
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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
//导入包
import org.springframework.util.DigestUtils;

/**
 * @author junfeng.hu
 * @create 2020-04-08 19:28
 */
@Service
public class JsoupService {



    private Logger logger = LoggerFactory.getLogger(JsoupService.class);

       @Autowired
       RobotUtilService robotUtilService;


        public  List<String> get() throws IOException {
            List<String> list = new ArrayList<>();
            Document document = Jsoup.connect(ConstantVar.contextPage).get();
            Elements elements = document.select("p");
            String line = elements.text();
            //8a5447c4f19b7a4e6445f8c7b251be73
            //8a5447c4f19b7a4e6445f8c7b251be73
            String md5Key = DigestUtils.md5DigestAsHex(line.getBytes());

            if (Singleton1.getInstanceA().getRedis().get(md5Key) != null){
                logger.info("这条信息已经发布过：" + line );
                return list;
            }
            // 加入缓存
            Singleton1.getInstanceA().getRedis().put(md5Key, 1);

            for (Element element : elements) {
                list.add(element.text());
            }
            // 填充list
            list.add(ConstantVar.copyright);


            return list;
        }




    public  void control() throws Exception {
        Document document = Jsoup.connect(ConstantVar.ctlPage).get();
        Elements elements = document.select("p");

        logger.info("检查到开关状态:" + ConstantVar.flagCtl );

        if(ConstantVar.flagCtl.equals(elements.text())){
            return;
        }
        //检查到这条信息是否已经发送过
        List<String> contextList = get();
        if(contextList.size() == 0) {
            logger.info("检查到这条信息已经发送过， 因此跳过！");
            return;
        }

        FileUtils.createFile(contextList);

        logger.info("=========我這裡按下F10=========");
        robotUtilService.foo();
        return;
    }

}
