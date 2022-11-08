package com.example.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
public class Criteria { //보통 실무에서 페이징처리시 Criteria라고 이름을 짓는다.
    private int page;
    private int amount;

    public void createCriteria(){ //파라미터로 page,amount를 안받으면 page:1과 amount:10을 보낸다.
        createCriteria(1, 10);
    }

    public void createCriteria(int page, int amount){ //파라미터로 page,amount 받는 메소드
        this.page = page;
        this.amount = amount;
    }

    public String getQueryString(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("page", this.page)
                .queryParam("amount", this.amount);
        return builder.toUriString();
    }
}






















