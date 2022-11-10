package com.example.order.controller;

import com.example.order.service.ItemService;
import com.example.order.service.OrderSerive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/item/*")
public class ItemController {
    private final ItemService itemService;

    @GetMapping("list")
    public void list(Model model){
        model.addAttribute("items", itemService.showAll());
    }
}
