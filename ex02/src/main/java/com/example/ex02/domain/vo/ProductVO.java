package com.example.ex02.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductVO {

    private String name;
    private int price;
    private int stock;
    private String brand;

}
