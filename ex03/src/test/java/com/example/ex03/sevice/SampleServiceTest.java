package com.example.ex03.sevice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class SampleServiceTest {

    @Autowired
    SampleService sampleService;

    @Test
    public void doAddTest() {
        log.info("result: " + sampleService.doAdd("한동석", "3"));
    }
    /*doAdd()만 실행됬는데 AOP가 추가가되서 출력된것을 확인할수있다.*/
}




















