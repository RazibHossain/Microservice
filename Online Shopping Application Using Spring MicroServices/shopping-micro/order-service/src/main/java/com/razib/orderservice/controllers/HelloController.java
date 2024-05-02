package com.razib.orderservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/orderService")
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public Object hello(){
        return "hello";
    }
}
