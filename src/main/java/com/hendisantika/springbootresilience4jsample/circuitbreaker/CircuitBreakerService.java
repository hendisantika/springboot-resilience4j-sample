package com.hendisantika.springbootresilience4jsample.circuitbreaker;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-resilience4j-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/02/20
 * Time: 06.28
 */
@Service
public class CircuitBreakerService {

    public String func(String str) {
        if (str == null) {
            throw new RuntimeException();
        }
        return "success!!";
    }

    @CircuitBreaker(name = "circuitB")
    public String aop(String str) {
        if (str == null) {
            throw new RuntimeException();
        }
        return "success!!";
    }
}