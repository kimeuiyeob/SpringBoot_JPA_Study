package com.example.order.controller;

import com.example.order.domain.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class OrderControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void addTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/order/add")
                .param("orders[0].itemNumber", "3")
                .param("orders[0].itemCount", "10")
                .param("orders[1].itemNumber", "1")
                .param("orders[1].itemCount", "5"))
        .andReturn();
    }

    @Test
    public void cancelTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/order/cancel")
                .param("orderId", "202211037"))
        .andReturn();
    }

    @Test
    public void listTest() throws Exception {
//        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/order/list"))
//                .andReturn().getModelAndView().getModelMap().toString());

//        상품 번호로 주문 조회
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/order/item/list")
                .param("itemNumber", "3"))
        .andReturn().getModelAndView().getModelMap().toString());
    }
}














