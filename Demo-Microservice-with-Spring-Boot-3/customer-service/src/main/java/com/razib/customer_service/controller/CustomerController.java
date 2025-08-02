package com.razib.customer_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @RequestMapping(value = "/helloCustomer",method = RequestMethod.GET)
    public String getCust(){
        return "Hello Customer Service!";
    }
}
