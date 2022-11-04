package com.example.order.domain.dao;

import com.example.order.domain.vo.ItemVO;
import com.example.order.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemDAO {

    private final ItemMapper itemMapper;

    //    추가 (itemVO를 받아와서 추가해준다)
    public void save(ItemVO itemVO){
        itemMapper.insert(itemVO);
    }

    //    수정 (itemVO를 받아와서 수정해준다)
    public void setItem(ItemVO itemVO){
        itemMapper.update(itemVO);
    }

    //    조회 (itemNumber를 받아와 해당 넘버의 값들을 찾아와준다)
    //    SELECT 조회들은 찾아돌아와야되니까 return이 있다.
    public ItemVO findById(Long itemNumber){
        return itemMapper.select(itemNumber);
    }

    //    전체 조회 (itemVO전부를 조회한다)
    public List<ItemVO> findAll(){
        return itemMapper.selectAll();
    }

}
















