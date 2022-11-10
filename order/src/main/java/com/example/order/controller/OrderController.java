package com.example.order.controller;

import com.example.order.domain.vo.ItemVO;
import com.example.order.domain.vo.OrderDTO;
import com.example.order.domain.vo.OrderVO;
import com.example.order.service.OrderSerive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order/*")
@Slf4j
public class OrderController {
    private final OrderSerive orderSerive;

//    결제
    @PostMapping("add")
    public RedirectView add(OrderVO order){
        orderSerive.addOrder(order.getOrders());
        return new RedirectView("/order/list");
    }

//    취소
    @PostMapping("cancel")
    public RedirectView cancel(@RequestParam("orderId") List<String> orderIds){
        orderIds.forEach(orderId -> orderSerive.cancel(orderId));
        return new RedirectView("/item/list");
    }

//    전체 조회
    @GetMapping("list")
    public void list(Model model){
        model.addAttribute("orders", orderSerive.showAll());
    }

//    상품명으로 주문 개수 조회
    @GetMapping("search") /*헤더에서 상품검색할때 여기로 온다. method=""를 쓰지 않았기때문에 기본방식인 get방식으로 받는다.*/
    public String search(@ModelAttribute("itemName") String itemName, Model model){ /*header.html에서 인풋태그의 itemName을 받아온다.*/
        model.addAttribute("total", orderSerive.show(itemName).stream().map(order -> order.getItemCount()).reduce(0, (count1, count2) -> count1 + count2));
        return "/order/result";
        /*@ModelAttribute("itemName")을 받아와서 String itemName으로 파라미터 받고 아래 .show()안에 itemName을 보내서 해당이름과 같은 VO를 조회한다.*/
    }
}
















