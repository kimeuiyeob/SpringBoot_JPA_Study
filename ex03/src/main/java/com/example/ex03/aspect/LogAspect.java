package com.example.ex03.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Configuration
@Slf4j
public class LogAspect {
    @Before("@annotation(com.example.ex03.aspect.LogStatus)")
    public void beforeStart(JoinPoint joinPoint){
        log.info("joinPoint: " + joinPoint);
        log.info("method: " + joinPoint.getSignature().getName());
        log.info("arguments: " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", ")));
    }

    @AfterReturning(value = "@annotation(com.example.ex03.aspect.LogStatus)", returning = "returnValue")
    public void afterReturningStart(JoinPoint joinPoint, Integer returnValue){
        log.info("after returning");
        log.info("result: " + returnValue);
    }

    @After("@annotation(com.example.ex03.aspect.LogStatus)")
    public void afterStart(JoinPoint joinPoint){
        log.info("joinPoint: " + joinPoint);
        log.info("method: " + joinPoint.getSignature().getName());
        log.info("arguments: " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", ")));
    }

//    예외처리를 하지 않고, 발생한 예외 정보만 가져옴
//    예외 발생 시 Retry를 통해 다시 한 번 실행시키거나 다른 point cut으로 이동하게 할 수 있다.
    @AfterThrowing(value = "@annotation(com.example.ex03.aspect.LogStatus)", throwing = "e")
    public void afterThrowingStart(NumberFormatException e){
        log.info(e.getMessage());
        log.info("wrong parameter, change parameter to be able to parse integer");
    }
}























