package com.example.order.mapper;

import com.example.order.domain.vo.OrderDTO;
import com.example.order.domain.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
//    추가
    public void insert(OrderDTO orderDTO);
//    삭제
    public void delete(String orderId);
//    조회
    public List<OrderDTO> select(String itemName);
    public List<OrderDTO> selectOrder(String orderId);
//    전체 조회
    public List<OrderDTO> selectAll();
//    주문 번호 조회
    public String selectOrderId();
//    주문 번호 증가
    public void next();
//    주문 번호 추가
    public void insertOrderSequence();
}
