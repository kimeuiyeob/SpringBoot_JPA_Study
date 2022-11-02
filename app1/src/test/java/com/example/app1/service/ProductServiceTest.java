package com.example.app1.service;


import com.example.app1.domain.vo.ProductVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;


    @Test
    public void selectTest() {
        Long productNumber = 2L;
        productService.find(productNumber);
    }

    @Test
    public void addTest() {

        ProductVO productVO = new ProductVO();
        productVO.setProductName("아직도몰라");
        productVO.setProductCompany("다들루와");
        productVO.setProductPrice(45000);

        productService.add(productVO);
    }

    @Test
    public void updateTest() {

        Long productNumber = 2L;
        ProductVO productVO = productService.find(productNumber);
        productVO.setProductName("벌뮤다");
        productVO.setProductCompany("우린황인종");
        productVO.setProductPrice(33000);

        productService.update(productVO);
    }


    @Test
    public void deleteTest() {
        Long productNumber = 2L;
        productService.delete(productNumber);
    }

}
