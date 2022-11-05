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

    @Test
    public void saveTest(){
        ItemVO itemVO =  new ItemVO();
        itemVO.setItemName("당근");
        itemVO.setItemPrice(1500);
        itemVO.setItemStock(90);

        itemDAO.save(itemVO);
    }

    @Test
    public void setItemTest(){
        ItemVO itemVO = itemDAO.findById(2L);
        itemVO.setItemStock(itemVO.getItemStock()  + 8);
        itemDAO.setItem(itemVO);
    }

    @Test
    public void findByIdTest(){
        ItemVO itemVO = itemDAO.findById(3L);
        log.info(itemVO.toString());
    }

    @Test
    public void findAll() {
        itemDAO.findAll().stream().map(item -> item.getItemName()).forEach(log::info);
    }
}
