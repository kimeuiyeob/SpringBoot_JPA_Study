package com.example.order.mapper;

import com.example.order.domain.vo.ItemVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
//    추가
    public void insert(ItemVO itemVO);
//    수정
    public void update(ItemVO itemVO);
//    조회
    public ItemVO select(Long itemNumber);
//    전체 조회
    public List<ItemVO> selectAll();
}
