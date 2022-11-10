package com.example.order.service;

import com.example.order.domain.dao.ItemDAO;
import com.example.order.domain.vo.ItemVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemDAO itemDAO;

//    전체 조회
    public List<ItemVO> showAll(){
        return itemDAO.findAll();
    }
}
