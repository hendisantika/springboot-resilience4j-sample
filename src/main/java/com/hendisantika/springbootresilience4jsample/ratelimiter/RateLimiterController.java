package com.hendisantika.springbootresilience4jsample.ratelimiter;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-resilience4j-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/02/20
 * Time: 06.31
 */
@RestController
@RequestMapping("/ratelimiter")
public class RateLimiterController {

    private final RateLimiter rateLimiter;
    private final RateLimiterService service;

    public RateLimiterController(RateLimiterRegistry registry, RateLimiterService service) {
        this.rateLimiter = registry.rateLimiter("limiterA");
        this.service = service;
    }
}
