package com.example.ex03.sevice;

import com.example.ex03.aspect.LogStatus;
import com.example.ex03.aspect.Plus10;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import static java.lang.Integer.*;

@Service
@Slf4j
public class SampleService {

    @Plus10
    @LogStatus
    public Integer doAdd(String str1, String str2) { //PointCut
        log.info("핵심 로직");
        return parseInt(str1) + parseInt(str2);
    }

    /*우선 먼저 핵심로직에서 다른메소드에서도 반복되는 로직을 분리해낸다*/
    /*위에 어노테이션으로 AOP를 쓰면 해당 메소드에 추가가된다*/
    /*하지만 around같은경우는 그쪽에서 이메소드를 관리해버린다.*/
}
