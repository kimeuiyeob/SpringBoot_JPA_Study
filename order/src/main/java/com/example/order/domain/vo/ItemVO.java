package com.example.order.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ItemVO {
    private Long itemNumber;
    private String itemName;
    private int itemPrice;
    private int itemStock;
}
