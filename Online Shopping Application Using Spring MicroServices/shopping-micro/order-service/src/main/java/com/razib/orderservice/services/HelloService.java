package com.razib.orderservice.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
//@RequiredArgsConstructor
public class HelloService {
//    @Autowired
    private final WebClient.Builder webClientBuilder;
    public HelloService(WebClient.Builder webClientBuilder){
        this.webClientBuilder = webClientBuilder;
    }
    public Object communicateWithInventoryService() {
        Object obj = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventoryService/hello?ajax")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return obj;
    }
}
