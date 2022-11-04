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
    //itemMapper에 있는 메소드를 테스트해보기 위해 객체화

    @Test
    public void insertTest(){
        ItemVO itemVO =  new ItemVO();
        //itemVO 객체화해서 set으로 새로운 값들을 넣어준다
        itemVO.setItemName("고구마");
        itemVO.setItemPrice(3000);
        itemVO.setItemStock(3);
        //itemMapper.insert() 사용해서 새로운 값을 넣은 itemVO를 DB에 넣어준다.
        itemMapper.insert(itemVO);
    }

    @Test
    public void updateTest(){
        ItemVO itemVO = itemMapper.select(1L);
        //itemMapper.select()로 itemNumber가 1인걸 수정시켜준다.
        itemVO.setItemStock(itemVO.getItemStock()  + 20);
        //set을 사용해서 itemStock값을 수정하는데 (원래 디비에 있던 itemStock갯수에다가 +20을 해준다)
        //(itemVO.getItemStock() 이걸 안해주면 itemStock 갯수가 얼마인지간에 20으로 바껴버린다)
        itemMapper.update(itemVO);
        //itemMapper.update() 사용해서 수정된 itemVO를 DB에 넣어준다.
    }

    @Test //해당 넘버로 해당 컬럼값 조회
    public void selectTest(){
        //itemNumber 1인 값들을 조회한다.
        ItemVO itemVO = itemMapper.select(1L);
        log.info(itemVO.toString());
    }

    @Test //전체 목록 조회
    //itemMapper.selectAll() 사용해서 forEach로 itemName을 다 뽑아온다.
    public void selectAll(){
        itemMapper.selectAll().stream().map(item -> item.getItemName()).forEach(log::info);
    }
}




















