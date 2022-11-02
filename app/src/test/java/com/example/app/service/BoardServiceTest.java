package com.example.app.service;

import com.example.app.domain.dao.BoardDAO;
import com.example.app.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class BoardServiceTest {


    @Autowired
    private BoardService boardService;

    @Test
    public void showTest(){
        boardService.show().stream().map(BoardVO::toString).forEach(log::info);
    }

    @Test
    public void addTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("테스트 제목2");
        boardVO.setBoardWriter("testB");
        boardVO.setBoardContent("테스트 내용2");
        boardService.add(boardVO);
        log.info("추가된 게시글 번호: " + boardVO.getBoardNumber());
    }

    @Test
    public void updateTest(){
        BoardVO boardVO  = boardService.find(1L);
        Assertions.assertNotNull(boardVO);
        boardVO.setBoardTitle("수정된 게시글 제목");
        log.info("UPDATE: " + boardService.update(boardVO));
    }

    @Test
    public void deleteTest(){
        Long boardNumber = 12L;
        BoardVO boardVO = boardService.find(boardNumber);
        Assertions.assertNotNull(boardVO);
        boardService.delete(boardNumber);
    }
}