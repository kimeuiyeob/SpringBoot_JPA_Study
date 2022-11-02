package com.example.app1.mapper;


import com.example.app1.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void selectTest(){
        Long productNumber =1L;
        productMapper.select(productNumber);
    };

    @Test
    public void insertTest(){

        ProductVO productVO = new ProductVO();

        productVO.setProductName("자");
        productVO.setProductCompany("삼성");
        productVO.setProductPrice(3000);

        productMapper.insert(productVO);
    };

    @Test
    public void updateTest(){

        Long productNumber = 1L;
        ProductVO productVO = productMapper.select(productNumber);

        productVO.setProductName("고릴라");
        productVO.setProductCompany("침팬지");
        productVO.setProductPrice(4500);

        productMapper.update(productVO);

    }

    @Test
    public void deleteTest() {

        Long productNumber = 1L;
        productMapper.delete(productNumber);
    }

}
