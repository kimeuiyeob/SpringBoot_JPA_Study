package com.example.order.controller;

import com.example.order.domain.vo.OrderVO;
import com.example.order.mapper.ItemMapper;
import com.example.order.service.OrderSerive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order/*")
public class OrderController {
    private final OrderSerive orderSerive;
    private ItemMapper itemMapper;

//    결제
    @GetMapping("add")
    public void add(OrderVO order){
        orderSerive.addOrder(order.getOrders());
    }

/*//    취소
    @GetMapping("cancel")
    public void cancel(String orderId){
        orderSerive.cancel(orderId);
    }*/

//    전체 조회
    @GetMapping("list")
    public void list(Model model){
        model.addAttribute("orders", orderSerive.showAll());
    }

/*//    상품 번호로 주문 조회
    @GetMapping("list")
    public void list(Long itemNumber, Model model){
        model.addAttribute("orders", orderSerive.show(itemNumber));
    }*/

/*//    검색 된 상품의 전체 주문 개수 출력
    @PostMapping("result")
    public void searchListLong (Long itemNumber, Model model) {
        model.addAttribute("orders", orderSerive.show(itemNumber));
    }*/

    @GetMapping("result") //당근
    public void searchDang(Model model){
        model.addAttribute("orders", itemMapper.selectDanggun());
    }

    @GetMapping("result2") //고구마
    public void searchGo(Model model){

        model.addAttribute("orders", itemMapper.selectGoguma());
    }

}
















