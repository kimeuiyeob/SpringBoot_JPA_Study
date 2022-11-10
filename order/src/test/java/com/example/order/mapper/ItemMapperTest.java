package com.example.order.mapper;

import com.example.order.domain.vo.ItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ItemMapperTest {
    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void insertTest(){
        ItemVO itemVO =  new ItemVO();
        itemVO.setItemName("고구마");
        itemVO.setItemPrice(3000);
        itemVO.setItemStock(3);

        itemMapper.insert(itemVO);
    }

    @Test
    public void updateTest(){
        ItemVO itemVO = itemMapper.select(1L);
        itemVO.setItemStock(itemVO.getItemStock()  + 20);
        itemMapper.update(itemVO);
    }

    @Test
    public void selectTest(){
        ItemVO itemVO = itemMapper.select(1L);
        log.info(itemVO.toString());
    }

    @Test
    public void selectAll(){
        itemMapper.selectAll().stream().map(item -> item.getItemName()).forEach(log::info);
    }
}




















