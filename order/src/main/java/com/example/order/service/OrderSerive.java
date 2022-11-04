package com.example.order.service;

import com.example.order.domain.dao.ItemDAO;
import com.example.order.domain.dao.OrderDAO;
import com.example.order.domain.vo.ItemVO;
import com.example.order.domain.vo.OrderDTO;
import com.example.order.domain.vo.OrderVO;
import com.example.order.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderSerive {

    private final ItemDAO itemDAO;
    private final OrderDAO orderDAO;

    //    결제
//    외부에서 주문할 항목들을 전달받는다.
    public void addOrder(List<OrderVO> orders) {

//        주문 번호를 1 증가시킨다.
        orderDAO.setOrderSequence();

        for (OrderVO order : orders) {
            //주문한 itemNumber를 다 가져와 itemVO에 담아준다.
            ItemVO itemVO = itemDAO.findById(order.getItemNumber());
            //set으로 itemStock개수를 수정한다 (원래 있던 itemStock - 주문한 itemCount를해주면 내가 주문한 만큼 itemStock이 줄어든다.
            itemVO.setItemStock(itemVO.getItemStock() - order.getItemCount());
            //수정된 itemVO를 set으로 수정해준다.
            itemDAO.setItem(itemVO);

//            주문 번호를 생성한다.
            OrderDTO orderDTO = new OrderDTO(orderDAO.findId());

//            전달받은 주문 정보를 담아준다.
            orderDTO.setItemCount(order.getItemCount());
            orderDTO.setItemNumber(order.getItemNumber());

//            주문한 상품의 가격을 담아준다.
            orderDTO.setItemPrice(itemDAO.findById(order.getItemNumber()).getItemPrice());

//            주문한 상품의 총 가격을 담아준다.
            orderDTO.setOrderPrice();
            orderDAO.save(orderDTO);
        }
    }

    //    취소
    //외부에서 취소한 orderId(주문번호)를 가져온다.
    public void cancel(String orderId) {
        //orderId로 해당 컬럼 조회한다.
        for (OrderDTO order : orderDAO.findByOrderId(orderId)) {
            //주문한 itemNumber를 다 가져온다.
            ItemVO itemVO = itemDAO.findById(order.getItemNumber());
            //주문할때 stock - count해줬으니까 취소는 주문한 만큼 stock + count해준다. (원래상태로 되돌린것)
            itemVO.setItemStock(itemVO.getItemStock() + order.getItemCount());
            //set으로 itemVO에 넣어준다.
            itemDAO.setItem(itemVO);
        }
        //주문번호를 삭제한다.
        orderDAO.deleteById(orderId);
    }

    //    조회
    public List<OrderVO> show(Long itemNumber) {
        return orderDAO.findByItemNumber(itemNumber);
    }

    //    전체 조회
    public List<OrderDTO> showAll() {
        return orderDAO.findAll();
    }
}

