package com.razib.orderservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
//@RequiredArgsConstructor
public class HelloService {
    @Autowired
    private  WebClient.Builder webClientBuilder;
    public Object communicateWithInventoryService() {
        Object obj = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventoryService/hello?ajax")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return obj;
    }
}
