package com.razib.orderservice.controllers;

import com.razib.orderservice.services.HelloService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/orderService")
@Slf4j
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public Object hello(){

        Object obj = helloService.communicateWithInventoryService();

        return obj.toString();
    }

    public String fallbackMethod( RuntimeException runtimeException) {

        return "Oops! Something went wrong, please order after some time!";
    }

    @GetMapping(value = "hello2")
//    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod2")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public Mono<String> placeOrder() {

        Mono<String> x =   helloService.placeOrder();
        System.out.println();
        return x;
    }

    public Mono<String> fallbackMethod2( Throwable runtimeException) {
        log.info("Cannot Place Order Executing Fallback logic");
        return  Mono.just("Oops! Something went wrong, please order after some time!");
    }
}
