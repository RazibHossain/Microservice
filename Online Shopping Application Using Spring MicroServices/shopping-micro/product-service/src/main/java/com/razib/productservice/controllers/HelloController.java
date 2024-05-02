package com.razib.productservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/productService")
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public Object hello(){
        return "hello";
    }
}
