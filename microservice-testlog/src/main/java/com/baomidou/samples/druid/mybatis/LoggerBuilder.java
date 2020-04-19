package com.baomidou.samples.druid.mybatis;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerBuilder {
  public static String foo(){
    log.info("methodName","xxx");
    return "foo bar";
  }

  public static void main(String[] args) {
    LoggerBuilder.foo();
  }
}