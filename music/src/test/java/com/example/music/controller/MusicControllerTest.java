package com.example.music.controller;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class MusicControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    //==============================================================================================

    @Test  //음악 전체 목록 조회
    public void showTest() throws Exception {
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/music/list")).andReturn().getModelAndView().getModelMap().toString());
    }

    @Test //음악 추가
    public void writeTest() throws Exception {
       log.info(mockMvc.perform(MockMvcRequestBuilders.post("/music/write")
               .param("musicTitle", "새로운 제목2")
               .param("musicSinger", "새로운 가수2")
               .param("musicLyrics", "새로운 가사2")).andReturn().getModelAndView().getViewName());
    }


    @Test //음악 수정
    public void updateTest() throws Exception {
        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/music/update")
                .param("musicNumber", "23")
                .param("musicTitle", "새로운 제목3")
                .param("musicSinger", "새로운 가수3")
                .param("musicLyrics", "새로운 가사3"))
                .andReturn().getModelAndView().getModelMap().toString());
    }

    @Test //음악 삭제
    public void deleteTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/music/delete")
            .param("musicNumber", "23"))
            .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }

}
