package com.example.order.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class OrderVO {
    private String orderId;
    private String orderDate;
    private Long itemNumber;
    private int itemCount;
    private int orderPrice;

    List<OrderVO> orders;
}
