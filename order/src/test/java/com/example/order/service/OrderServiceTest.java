package com.example.order.service;

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
public class OrderServiceTest {

    @Autowired
    private OrderSerive orderSerive;

    @Test
    public void addOrderTest() {

        List<OrderVO> orders = new ArrayList<>();

        OrderVO order1 = new OrderVO();
        order1.setItemNumber(3L);
        order1.setItemCount(10);

        OrderVO order2 = new OrderVO();
        order2.setItemNumber(2L);
        order2.setItemCount(2);

        orders.add(order1);
        orders.add(order2);

        orderSerive.addOrder(orders);
    }

    @Test
    public void cancelTest() {
        String orderId = "202211039";
        //이 주문번호를 넣어서 취소시킨다.
        orderSerive.cancel(orderId);
    }

    //    조회 테스트
    @Test
    public void showTest() {
        //itemNumber에 1을 넣어서 itemNumber가 1인걸 조회한다.
        Long itemNumber = 1L;
        orderSerive.show(itemNumber);
//        orderSerive.show(1L); //아래 위에 2가지 방식 사용가능!!
    }

    //    전체 조회 테스트
    @Test
    public void selectAllTest() {
        //전체조회니까 List로 받아와서 forEach로 뽑는다.
        orderSerive.showAll().stream().map(OrderDTO::toString).forEach(log::info);
    }

}
