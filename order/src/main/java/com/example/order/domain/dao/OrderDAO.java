package com.example.order.domain.dao;

import com.example.order.domain.vo.OrderDTO;
import com.example.order.domain.vo.OrderVO;
import com.example.order.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderDAO {
    private final OrderMapper orderMapper;

    //    추가
    public void save(OrderDTO orderDTO){
        orderMapper.insert(orderDTO);
    }
    //    삭제
    public void deleteById(String orderId){
        orderMapper.delete(orderId);
    }
    //    조회
    public List<OrderDTO> findByItemNumber(Long itemNumber){
        return orderMapper.select(itemNumber);
    }
    public List<OrderDTO> findByOrderId(String orderId){return orderMapper.selectOrder(orderId);}
    //    전체 조회
    public List<OrderDTO> findAll(){return orderMapper.selectAll();}
    //    주문 번호 조회
    public String findId(){
        return orderMapper.selectOrderId();
    }
    //    주문 번호 증가
    public void setOrderSequence(){
        orderMapper.next();
    }
    //    주문 번호 추가
    public void saveOrderSequence(){
        orderMapper.insertOrderSequence();
    }
}
