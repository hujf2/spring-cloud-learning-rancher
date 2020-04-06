package demo.spring.boot.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import demo.spring.boot.dubbo.api.GreetingService;

import java.time.LocalDateTime;

@Service(version = "${spring.application.version}",
    application = "${dubbo.application.id}",
    protocol = "${dubbo.protocol.id}",
    registry = "${dubbo.registry.id}")
public class GreetingServiceImpl implements GreetingService {
    
    @Override
    public String welcome(String name) {
        String msg = "Welcome " + name + " at " + LocalDateTime.now();
        System.out.println(msg);
        return msg;
    }
}