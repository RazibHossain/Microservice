package com.razib.customer_service.controller;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
	

	
	@GetMapping("/customers")
	public Object fetchAllCustomers() {
		return  "Hello";
	}
	

}
