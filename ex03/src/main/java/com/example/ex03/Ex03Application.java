package com.example.ex03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy //AOP 허용
@SpringBootApplication
public class Ex03Application {

    public static void main(String[] args) {
        SpringApplication.run(Ex03Application.class, args);
    }

}
