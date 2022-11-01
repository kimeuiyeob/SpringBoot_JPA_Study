package com.example.ex02.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TaskVO {

    private int num; //학생 넘버
    private int kor;
    private int eng;
    private int math;

    public int getTotal() { //총점 구하는 메소드
        return kor + eng + math; //kor점수, eng점수, math점수를 더한걸 return해준다.
    }

    public double getAverage() { //평균값 구하는 메소드
        return getTotal() / 3.0; //총점수 나누기3을 해준걸 return해준다.
    }
}