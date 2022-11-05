package com.example.app.service;

import com.example.app.domain.dao.BoardDAO;
import com.example.app.domain.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Qualifier("community") @Primary
@RequiredArgsConstructor
public class CommunityService implements BoardService{
    //BoardService인터페이스 구현해서 바디 완성

    private final BoardDAO boardDAO;

    @Override
    public List<BoardVO> show() {
        return boardDAO.findAll();
    }

    @Override
    public BoardVO find(Long boardNumber) {
        return boardDAO.findById(boardNumber);
    }

    @Override
    public boolean add(BoardVO boardVO) {
        return boardDAO.save(boardVO) == 1;
    }
    //boolean타입으로 받았으니까 ==1을 해준다.

    @Override
    public boolean update(BoardVO boardVO) {
        return boardDAO.setBoard(boardVO) == 1;
    }

    @Override
    public boolean delete(Long boardNumber) {
        return boardDAO.deleteById(boardNumber) == 1;
    }
}
