package com.example.order.dao;

import com.example.order.domain.dao.ItemDAO;
import com.example.order.domain.dao.OrderDAO;
import com.example.order.domain.vo.OrderDTO;
import com.example.order.domain.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class OrderDAOTest {
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private ItemDAO itemDAO;

    @Test
    public void saveTest(){
//        주문을 추가할 때마다 주문 번호가 1씩 증가한다.
        orderDAO.setOrderSequence();

//        여러 개의 상품을 주문했을 경우
        List<OrderDTO> orders = new ArrayList<>();
//        각 상품을 화면에서 받아온 정보로 채우고
        OrderDTO order1 = new OrderDTO(orderDAO.findId());
        order1.setItemNumber(3L);
        order1.setItemCount(10);

        OrderDTO order2 = new OrderDTO(orderDAO.findId());
        order2.setItemNumber(1L);
        order2.setItemCount(2);

//        주문 목록에 담아준다.
        orders.add(order1);
        orders.add(order2);

        for (OrderDTO order: orders) {
//            주문한 상품의 가격을 담아주고
            order.setItemPrice(itemDAO.findById(order.getItemNumber()).getItemPrice());
//            총 가격을 구해준다.
            order.setOrderPrice();
            orderDAO.save(order);
        }
    }

    @Test
    public void deleteByIdTest(){
        orderDAO.deleteById("202211036");
    }

    @Test
    public void findByItemNumberTest(){
        log.info("전체 감자 판매 개수 : " + orderDAO.findByItemNumber(1L).stream().map(order -> order.getItemCount()).reduce(0, (count1, count2) -> count1 + count2));
    }

    @Test
    public void findByOrderId(){
        orderDAO.findByOrderId("202211038").forEach(order -> log.info("취소된 " + order.getItemName() + "의 개수 " + order.getItemCount()));
    }

    @Test
    public void findAllTest(){
        orderDAO.findAll().stream().map(OrderDTO::toString).forEach(log::info);
    }
}
