package com.hendisantika.springbootresilience4jsample.circuitbreaker;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-resilience4j-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/02/20
 * Time: 06.29
 */
@RestController
@RequestMapping("/circuit")
public class CircuitBreakerController {

    private final CircuitBreaker circuitBreaker;
    private final CircuitBreakerService service;

    public CircuitBreakerController(CircuitBreakerRegistry registry, CircuitBreakerService service) {
        this.circuitBreaker = registry.circuitBreaker("circuitA");
        this.service = service;
    }
}
