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

##  CircuitBreaker
When some services fail in a microservice, you can temporarily block access to the failed service to prevent its propagation.

CircuitBreaker has three states: Closed, Open, and HalfOpen.
It is Closed at normal time, and if the processing fails more than a certain amount, it becomes Open and blocks access.
After a certain period of time in the Open state, the state changes to the HalfOpen state.
If processing does not fail more than a certain amount in the HalfOpen state, the flow returns to the Closed state.

Resilience4j manages the success and failure of processing in the ring buffer, and the state changes when the number of failures in the buffer exceeds the set ratio.
It looks like the figure below shows that failure is held as 0 and success is held as 1.

The ring buffer used in the judgment of Closed-> Open and HalfOpen-> Closed is different, and the size can be defined respectively, but the same value is used for the judgment condition (error rate).

State transition does not take place until the ring buffer is full.
For example, if the state of the ring buffer changes to 10 or 50% or more, even if an
error occurs five times in a row , the state does not change to Open because the ring buffer is not full.

The success or failure of the process is determined by the exception.
By default, any exception will be considered a failure if an exception is thrown, but you can also specify conditions for failure.

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