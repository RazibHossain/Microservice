package com.razib.orderservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
//@RequiredArgsConstructor
public class HelloService {
    @Autowired
    private  WebClient webClient;
    public Object communicateWithInventoryService() {
        Object obj = webClient.get()
                .uri("http://localhost:7777/api/inventoryService/hello?ajax")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return obj;
    }
}
