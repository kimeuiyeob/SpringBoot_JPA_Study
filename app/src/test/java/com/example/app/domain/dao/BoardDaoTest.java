package com.example.app.domain.dao;

import com.example.app.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardDAOTest {

    @Autowired
    private BoardDAO boardDAO;

    @Test //게시글 전체 목록 조회니까 VO가 여러개 있으므로 forEach로 출력하기
    public void findAllTest(){
        boardDAO.findAll().stream().map(BoardVO::toString).forEach(log::info);
    }

    @Test //게시글 추가
    public void saveTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("테스트 제목2");
        boardVO.setBoardWriter("testB");
        boardVO.setBoardContent("테스트 내용2");
        boardDAO.save(boardVO);
        log.info("추가된 게시글 번호: " + boardVO.getBoardNumber());
    }

    @Test //게시글 수정
    public void setBoardTest(){
        BoardVO boardVO  = boardDAO.findById(1L);
        Assertions.assertNotNull(boardVO);
        boardVO.setBoardTitle("수정된 게시글 제목");
        log.info("UPDATE COUNT: " + boardDAO.setBoard(boardVO));
    }

    @Test //게시글 삭제
    public void deleteByIdTest(){
        Long boardNumber = 3L;
        BoardVO boardVO = boardDAO.findById(boardNumber);
        Assertions.assertNotNull(boardVO);
        boardDAO.deleteById(boardNumber);
    }
}
