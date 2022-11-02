package com.example.app1.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductVO {

    private Long productNumber;
    private String productName;
    private String productCompany;
    private int productPrice;
    private String productRegisterDate;
    private String productUpdateDate;

}
