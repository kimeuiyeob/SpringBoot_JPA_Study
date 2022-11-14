package com.example.ex03.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
@Slf4j
public class Plus10Aspect {

    /*point 시점*/
    /*joinpoint*/
    @Around("@annotation(com.example.ex03.aspect.Plus10)")
    public Integer aroundPlus10(ProceedingJoinPoint proceedingJoinPoint) {
        /*proceedingJoinPoint이게 doADD 로직을 가져온다*/ /*around에 proceeding 실행까지 시킬수있다*/
        Integer result = null;
        try {
            result = (Integer)proceedingJoinPoint.proceed(); /*메인로직을 여기서 실행*/
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result + 10;
    }

}
