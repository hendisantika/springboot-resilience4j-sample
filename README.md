# springboot-resilience4j-sample

##  Try CircuitBreaker and RateLimiter with Spring Boot + Resilience4j
[When](https://github.com/Netflix/Hystrix) I thought about checking [Netflix Hystrix](https://github.com/Netflix/Hystrix),  
it seemed to be in maintenance mode, and the image posted on the [Netflix blog](https://netflixtechblog.com/netflix-oss-and-spring-boot-coming-full-circle-4855947713a0) showed Resilience4j instead of Hystrix. I looked it up.

##  Resilience4jResilience4j provides the following functions.
- CircuitBreaker
- RateLimiter
- Bulkhead
- Retry
- Cache
- TimeLimiter

Starter is provided for use with Spring Boot.
Note that the artifactId is different between Spring Boot 1.x and 2.x systems.
Also, only CircuitBreaker and RateLimiter are included in the above. If you want to use other functions, you need to add additional dependency.
(Because AutoConfigure is not prepared, you also need to define the bean yourself.)

This time, I will summarize how to use CircuitBreaker and RateLimiter in Spring Boot 2.x series.

##  Fallback processing
As with CircuitBreaker, there is no mechanism to execute fallback processing automatically, so you need to implement it yourself.
It is OK if you process it with your favorite method, such as a method using Vavr's try monad or an ordinary try-catch.

##  Operation check
The unit time is 5 seconds, the timeout period is 1 second, and the number of executions per unit time is 1.
If you send multiple requests at the same time, some requests will fail.
(If you request three at the same time, at least one will always fail.)

## Rate Limiter Function
```
curl http://localhost:8080/ratelimiter/func
```

## Rate Limiter AOP
```
curl http://localhost:8080/ratelimiter/aop
```