package com.razib.orderservice.controllers;

import com.razib.orderservice.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/orderService")
public class HelloController {

//    @Autowired
//    HelloService helloService;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public Object hello(){

//        Object obj = helloService.communicateWithInventoryService();

        return "hello";
    }
}
