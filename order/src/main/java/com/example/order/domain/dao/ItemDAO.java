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

    //    추가
    public void save(ItemVO itemVO){
        itemMapper.insert(itemVO);
    }
    //    수정
    public void setItem(ItemVO itemVO){
        itemMapper.update(itemVO);
    }
    //    조회
    public ItemVO findById(Long itemNumber){
        return itemMapper.select(itemNumber);
    }
    //    전체 조회
    public List<ItemVO> findAll(){
        return itemMapper.selectAll();
    }
}
















