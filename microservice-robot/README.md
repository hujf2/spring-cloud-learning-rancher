调用关系：
microservice-robot --》 microservice-myuser --》 microservice-order

# SpringCloud 整合 Sentinel
# 一般三步：加依赖、加注解、加配置

`
spring:
  application:
    name: microservice-robot
  cloud:
    sentinel:
      transport:
#        port: 8719
        dashboard: 192.168.213.1:8080
    nacos:
      discovery:
        server-addr: 192.168.213.1:8848
      config:
        server-addr: 192.168.213.1:8848
        # 共享的配置列表
        shared-dataids: foo.yaml,bar.yaml
        refreshable-dataids: foo.yaml,bar.yaml
        file-extension: yaml
`

`feign:
  sentinel:
    enabled: true`
    
`<?xml version="1.0" encoding="UTF-8"?>
 <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
     <modelVersion>4.0.0</modelVersion>
 
     <groupId>com.itmuch.cloud</groupId>
     <artifactId>spring-cloud-learning-rancher</artifactId>
     <version>0.0.1-SNAPSHOT</version>
     <packaging>pom</packaging>
 
     <modules>
         <module>microservice-robot</module>
         <module>microservice-order</module>
         <module>microservice-myuser</module>
     </modules>
 
     <properties>
         <spring-cloud.version>Greenwich.RELEASE</spring-cloud.version>
         <spring-cloud-alibaba.version>2.1.0.RELEASE</spring-cloud-alibaba.version>
         <dubbo.version>2.7.6</dubbo.version>
 
         <com.mapabc.common.version>1.0.2</com.mapabc.common.version>
         <com.mapabc.model.version>1.0.1</com.mapabc.model.version>
         <com.mapabc.protobuf.version>1.0.1</com.mapabc.protobuf.version>
         <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
         <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
         <java.version>1.8</java.version>
     </properties>
 
     <parent>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-parent</artifactId>
         <version>2.1.5.RELEASE</version>
     </parent>
 
     <dependencies>
         <dependency>
             <groupId>com.alibaba.cloud</groupId>
             <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
         </dependency>
 
 
         <!-- 1. nacos-增加配置中心的依赖 -->
         <dependency>
             <groupId>com.alibaba.cloud</groupId>
             <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
         </dependency>
 
         <!-- 2. nacos-服务发现功能依赖 -->
         <dependency>
             <groupId>com.alibaba.cloud</groupId>
             <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
         </dependency>
         <!-- 2. 引入open-foreign-->
         <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-openfeign</artifactId>
         </dependency>
 
         <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-web</artifactId>
         </dependency>
 
         <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-test</artifactId>
             <scope>test</scope>
         </dependency>
 
         <!-- Spring boot actuator to expose metrics endpoint -->
         <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-actuator</artifactId>
         </dependency>
         <!-- Micormeter core dependecy  -->
         <dependency>
             <groupId>io.micrometer</groupId>
             <artifactId>micrometer-core</artifactId>
         </dependency>
         <!-- Micrometer Prometheus registry  -->
         <dependency>
             <groupId>io.micrometer</groupId>
             <artifactId>micrometer-registry-prometheus</artifactId>
         </dependency>
 
     </dependencies>
 
     <dependencyManagement>
         <dependencies>
 
             <dependency>
                 <groupId>org.hibernate</groupId>
                 <artifactId>hibernate-validator</artifactId>
             </dependency>
 
 
             <dependency>
                 <groupId>com.fasterxml.jackson.core</groupId>
                 <artifactId>jackson-databind</artifactId>
             </dependency>
 
             <!--SpringCloud-->
             <dependency>
                 <groupId>org.springframework.cloud</groupId>
                 <artifactId>spring-cloud-dependencies</artifactId>
                 <version>${spring-cloud.version}</version>
                 <type>pom</type>
                 <scope>import</scope>
             </dependency>
             <!--SpringCloud Alibaba-->
             <dependency>
                 <groupId>com.alibaba.cloud</groupId>
                 <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                 <version>${spring-cloud-alibaba.version}</version>
                 <type>pom</type>
                 <scope>import</scope>
             </dependency>
 
         </dependencies>
     </dependencyManagement>
 
     <build>
         <plugins>
             <plugin>
                 <groupId>org.springframework.boot</groupId>
                 <artifactId>spring-boot-maven-plugin</artifactId>
                 <dependencies>
                     <dependency>
                         <groupId>org.springframework</groupId>
                         <artifactId>springloaded</artifactId>
                         <version>1.2.5.RELEASE</version>
                     </dependency>
                 </dependencies>
             </plugin>
             <plugin>
                 <groupId>org.mybatis.generator</groupId>
                 <artifactId>mybatis-generator-maven-plugin</artifactId>
                 <version>1.3.2</version>
                 <configuration>
                     <configurationFile>${basedir}/src/main/resources/generator/generatorConfig.xml</configurationFile>
                     <overwrite>true</overwrite>
                     <verbose>true</verbose>
                 </configuration>
                 <dependencies>
                     <dependency>
                         <groupId>mysql</groupId>
                         <artifactId>mysql-connector-java</artifactId>
                         <version>${mysql.version}</version>
                     </dependency>
                     <dependency>
                         <groupId>tk.mybatis</groupId>
                         <artifactId>mapper-generator</artifactId>
                         <version>1.0.0</version>
                     </dependency>
                 </dependencies>
             </plugin>
         </plugins>
     </build>
 </project>
`
# 通过feign 进行调用

`@FeignClient(name = "microservice-order", fallback = FallbackRemoteClient.class)
 public interface RemoteClient {
 
     @GetMapping("/order/getOrderById")
 //    @GetMapping("/good/getGoodById")
     CallResult getGood();
 
 }`
 
 
 
 `@Slf4j
  @Component
  public class FallbackRemoteClient implements RemoteClient{
  
     @Override
     public CallResult getGood(){
          log.info("调用 订单 微服务失败，记录一条日志入库, 用于将来补偿");
          return CallResult.failure("调用 定单 微服务失败，记录一条日志入库, 用于将来补偿");
     }
  
  }
  
`

# 添加测试类
`package com.baomidou.samples.druid.mybatis.controller;
 
 import com.baomidou.samples.druid.mybatis.controller.myuser.RemoteClientMyUser;
 import com.baomidou.samples.druid.mybatis.controller.ordercall.RemoteClientGood;
 import com.baomidou.samples.druid.mybatis.service.message.JsoupService;
 import com.baomidou.samples.druid.mybatis.structrue.CallResult;
 import com.baomidou.samples.druid.mybatis.utils.RobotUtil;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.beans.factory.annotation.Qualifier;
 import org.springframework.cloud.context.config.annotation.RefreshScope;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.bind.annotation.RestController;
 
 import java.awt.*;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.List;
 
 
 @RefreshScope
 @RestController
 public class MyController {
 
 
     @Autowired
     @Qualifier("skip")
     private List<String> skip;
 
     @Autowired
     JsoupService jsoupService;
 
     @SuppressWarnings("all")
     @Autowired
     RemoteClient remoteClient;
 
 
     @SuppressWarnings("all")
     @Autowired
     RemoteClientGood remoteClientGood;
 
     @SuppressWarnings("all")
     @Autowired
     RemoteClientMyUser remoteClientMyUser;
 
     @RequestMapping(value="/my/config", method={RequestMethod.GET})
     public CallResult myUserService2() throws Exception {
         System.out.println("skip.size() = " + skip.size());
         for (int i = 0; i < skip.size(); i++) {
             System.out.println("skip = " + skip.get(i));
         }
         return CallResult.success(new Date());
     }
 
     @RequestMapping(value="/callmyuser", method={RequestMethod.GET})
     public CallResult query3() throws Exception {
         System.out.println(" ...... call 。。。。 " );
         return CallResult.success(remoteClientMyUser.getGood());
     }
 
 
     @RequestMapping(value="/queryGood", method={RequestMethod.GET})
     public CallResult query() throws Exception {
         System.out.println(" ...... call 。。。。 " );
         return CallResult.success(remoteClient.getGood());
     }
 
     @RequestMapping(value="/realQueryGood", method={RequestMethod.GET})
     public CallResult query2() throws Exception {
         System.out.println(" ...... call 。。。。 " );
         return CallResult.success(remoteClientGood.getGood());
     }
 
 
 
    
 }
 
`