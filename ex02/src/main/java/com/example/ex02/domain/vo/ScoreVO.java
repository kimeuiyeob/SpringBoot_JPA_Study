package com.example.ex02.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ScoreVO {

    private int korea;
    private int english;
    private int math;
    private int history;

    public int getTotal() {
        return korea + english + math + history;
    }

    public int getAverage() {
        return getTotal()/4;
    }

}
