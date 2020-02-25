package com.hendisantika.springbootresilience4jsample.ratelimiter;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-resilience4j-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/02/20
 * Time: 06.30
 */
@Service
public class RateLimiterService {

    public String func() {
        return LocalDateTime.now().toString();
    }

    @RateLimiter(name = "limiterB")
    public String aop() {
        return LocalDateTime.now().toString();
    }
}