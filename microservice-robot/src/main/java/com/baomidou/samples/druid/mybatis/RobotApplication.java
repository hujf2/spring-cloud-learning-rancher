package com.baomidou.samples.druid.mybatis;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan("com.baomidou.samples.druid.mybatis.*")
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan("com.baomidou.samples.druid.mybatis.mapper")
public class RobotApplication {
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean (name = "skip")
  @ConfigurationProperties( prefix = "ignore.skip" )
  public List<String> ignoreSkip(){
    return new ArrayList<String>();
  }

  @Bean (name = "holiday")
  @ConfigurationProperties( prefix = "ignore.holiday" )
  public List<String> ignoreHoliday(){
    return new ArrayList<String>();
  }


  @Bean (name = "salesDepartment")
  @ConfigurationProperties( prefix = "department.sales.member" )
  public List<String> salesDepartment(){
    return new ArrayList<String>();
  }

  @Bean (name = "systemPushMessage")
  @ConfigurationProperties( prefix = "system.push.message" )
  public List<String> systemPushMessage(){
    return new ArrayList<String>();
  }


  @Bean (name = "systemPushWebhook")
  @ConfigurationProperties( prefix = "system.push.webhook" )
  public List<String> systemPushWebhook(){
    return new ArrayList<String>();
  }

  @Bean
  public DemoMetrics demoMetrics(){
    return new DemoMetrics();
  }


//  public static void main(String[] args) {
//
//    SpringApplication.run(RobotApplication.class, args);
//  }

  public static void main(String[] args) {
    SpringApplicationBuilder builder = new SpringApplicationBuilder(RobotApplication.class);
    //SpringApplication.run(SystemctlApplication.class, args);
    builder.headless(false)
            // .web(WebApplicationType.NONE)
            // .bannerMode(Banner.Mode.OFF)
            .run(args);
  }

}