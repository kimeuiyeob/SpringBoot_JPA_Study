package com.example.app1.controller;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class ProductControllerTest {

    @Autowired
    public WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test //insert
    public void putTest() throws Exception {
        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/ex/put")
                .param("productName", "우장창창")
                .param("productCompany", "울랄라")
                .param("productPrice", "5000"))
                .andReturn().getModelAndView().getViewName());
    }

    @Test //update
    public void changeTest() throws Exception {
        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/ex/change")
                .param("productNumber", "5")
                .param("productName", "우쾅쾅코아")
                .param("productCompany", "코아아아")
                .param("productPrice", "5000"))
                .andReturn().getModelAndView().getModelMap().toString());
    }

    @Test //delete
    public void deleteTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/ex/change")
                .param("productNumber", "5"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }

}
