package com.razib.order_service.controller;


import com.razib.order_service.client.CustomerClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderController {
	
	@Autowired
	private CustomerClient customerClient;
	

	
	@GetMapping("/orders")
	@CircuitBreaker(name="customerServiceCB", fallbackMethod="fallbackGetCustomer")
	public Object hello() {
		System.out.println("inside order service");
		String response =customerClient.getCustomerById();
		System.out.println(response);
		return  response;
	}

	public Object fallbackGetCustomer(Throwable t) {

		t.printStackTrace();
		return "Opss Down!";
	}

}
