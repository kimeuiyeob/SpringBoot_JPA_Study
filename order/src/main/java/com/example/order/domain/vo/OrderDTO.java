package com.example.order.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString @NoArgsConstructor @RequiredArgsConstructor
public class OrderDTO {
    @NonNull
    private String orderId;
    private String orderDate;
    private Long itemNumber;
    private String itemName;
    private int itemCount;
    private int orderPrice;
    private int itemPrice;
    private int itemStock;

    public void setOrderPrice(){
        this.orderPrice = this.itemCount * this.itemPrice;
    }

    public void setItemNumber(Long itemNumber) {
        this.itemNumber = itemNumber;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemName(String itemName) {this.itemName = itemName;}

    public void setItemStock(int itemStock) {this.itemStock = itemStock;}
}
