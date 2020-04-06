
package com.cott.gmail.bootorderserviceconsumer.controller;

import com.cott.gmail.bean.UserAddress;
import com.cott.gmail.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @GetMapping("/initOrder")
    public List<UserAddress> initOrder(@RequestParam(name = "id") String id) {
        return orderService.initOrder(id);
    }
}