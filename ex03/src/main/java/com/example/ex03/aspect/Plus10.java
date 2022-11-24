package com.example.ex03.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //나는 메소드에 쓸꺼야,타겟 지정
@Retention(RetentionPolicy.RUNTIME)  //생명주기, 실행되있을동안
public @interface Plus10 {;} //분리된 횡단 관심사 인터페이스
