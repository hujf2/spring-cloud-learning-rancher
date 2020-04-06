package com.tengge.dubboconsumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import demo.spring.boot.dubbo.api.GreetingService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Reference(version = "${spring.application.version}",
        application = "${spring.application.id}",
        registry = "${dubbo.registry.address}")
    private GreetingService greetingService;
    
    @Scheduled(fixedRate = 3000)
    public void consume() {
        System.out.println(greetingService.welcome("Dubbo"));
    }
}