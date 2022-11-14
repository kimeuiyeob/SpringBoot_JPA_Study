package com.example.ex03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*AspectJ원본객체*/
/*Proxy가짜 객체*/
/*이 Proxy가 원본객체를 상속받아 복사한뒤 이 Proxy가 pointcut처리*/
/*Proxy가 pointcut과 advice 합처서 쏘는거다.*/
@EnableAspectJAutoProxy
@SpringBootApplication
public class Ex03Application {

    public static void main(String[] args) {
        SpringApplication.run(Ex03Application.class, args);
    }

}
