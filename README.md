# springboot-resilience4j-sample

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