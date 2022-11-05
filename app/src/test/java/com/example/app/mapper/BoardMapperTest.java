package com.example.app.mapper;

import com.example.app.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTest {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void getListTest(){
        boardMapper.getList().stream().map(BoardVO::toString).forEach(log::info);
    }

    @Test
    public void insertTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("테스트 제목2");
        boardVO.setBoardWriter("testB");
        boardVO.setBoardContent("테스트 내용2");
        boardMapper.insert(boardVO);
        log.info("추가된 게시글 번호: " + boardVO.getBoardNumber());
    }

    @Test
    public void updateTest(){
        BoardVO boardVO  = boardMapper.select(1L);
        Assertions.assertNotNull(boardVO);
        boardVO.setBoardTitle("수정된 게시글 제목");
        log.info("UPDATE COUNT: " + boardMapper.update(boardVO));
    }

    @Test
    public void deleteTest(){
        Long boardNumber = 2L;
        BoardVO boardVO = boardMapper.select(boardNumber);
        Assertions.assertNotNull(boardVO);
        boardMapper.delete(boardNumber);
    }
}
