package com.razib.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-service", url="http://localhost:8082")
public interface CustomerClient {
	@GetMapping("/helloCustomer")
	String getCustomerById();

}