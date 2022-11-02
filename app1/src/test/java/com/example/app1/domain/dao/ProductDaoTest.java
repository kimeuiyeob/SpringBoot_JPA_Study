package com.example.app1.domain.dao;


import com.example.app1.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductDaoTest {

    @Autowired
    private ProductDAO productDAO;

    @Test //insert
    public void saveTest(){

        ProductVO productVO = new ProductVO();
        productVO.setProductName("니손끝엔");
        productVO.setProductCompany("또눈물이");
        productVO.setProductPrice(40000);

        productDAO.save(productVO);
    }

    @Test //update
    public void setTest() {

        Long productNumber = 2L;
        ProductVO productVO = productDAO.find(productNumber);
        productVO.setProductName("간지짱짱");
        productVO.setProductPrice(5000);
        productVO.setProductCompany("킹왕짱");

        productDAO.set(productVO);
    }

    @Test //delete
    public void deleteTest() {

        Long productNumber = 5L;
        productDAO.delete(productNumber);
    }


}
