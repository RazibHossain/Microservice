package com.razib.orderservice.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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

    public Mono<String> placeOrder() {
        return webClientBuilder.build()
                .get()
                .uri("http://inventory-service/api/inventoryService/hello?ajax")
                .retrieve()
                .onStatus(status -> status.is5xxServerError(),
                        response -> Mono.error(new RuntimeException("Inventory service is down!")))
                .bodyToMono(String.class);
    }
}
