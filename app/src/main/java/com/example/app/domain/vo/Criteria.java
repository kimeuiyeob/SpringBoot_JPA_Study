package com.example.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
public class Criteria {
    private int page; /*게시판 하단부 1~10 페이지*/
    private int amount; /*게시글 수 10개로 정해놓은거*/
    private String type; /*검색때문에 만든거*/
    private String keyword; /*검색때문에 만든거*/

    public void createCriteria(){
        createCriteria(1, 10);
    } /*디폴트값으로 page1 ,amount 10으로 정한다.*/

    public void createCriteria(int page, int amount){
        this.page = page;
        this.amount = amount;
    }

    public String getQueryString(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("page", this.page)
                .queryParam("amount", this.amount);
        return builder.toUriString();
    }

    public String[] getTypes(){
        return type != null ? type.split("") : new String[] {};
    }
}






















