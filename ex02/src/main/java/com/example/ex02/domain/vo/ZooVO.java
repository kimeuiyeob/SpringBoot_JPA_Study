package com.example.ex02.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ZooVO {

    private String name;
    private String kind;
    private int number;
    private String food;

}
