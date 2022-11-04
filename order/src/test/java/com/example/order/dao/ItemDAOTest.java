package com.example.order.dao;

import com.example.order.domain.dao.ItemDAO;
import com.example.order.domain.vo.ItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ItemDAOTest {

    @Autowired
    private ItemDAO itemDAO;

    @Test //추가
    public void saveTest(){
        ItemVO itemVO =  new ItemVO();
        itemVO.setItemName("당근");
        itemVO.setItemPrice(1500);
        itemVO.setItemStock(90);

        itemDAO.save(itemVO);
    }

    @Test //수정
    public void setItemTest(){
        ItemVO itemVO = itemDAO.findById(2L);
        itemVO.setItemStock(itemVO.getItemStock()  + 8);
        itemDAO.setItem(itemVO);
    }

    @Test //해당 넘버로 컬럼 조회
    public void findByIdTest(){
        ItemVO itemVO = itemDAO.findById(3L);
        log.info(itemVO.toString());
    }

    @Test //전체 조회 (모든 itemName 조회하기)
    public void findAll() {
        itemDAO.findAll().stream().map(item -> item.getItemName()).forEach(log::info);
    }
}
