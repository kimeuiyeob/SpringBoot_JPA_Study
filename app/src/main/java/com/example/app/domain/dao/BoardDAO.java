package com.example.app.domain.dao;

import com.example.app.domain.vo.BoardVO;
import com.example.app.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {

    private final BoardMapper boardMapper;

    //    게시글 전체 목록 조회
    public List<BoardVO> findAll() {
        return boardMapper.getList();
    }

    //    게시글 번호로 조회
    public BoardVO findById(Long boardNumber) {
        return boardMapper.select(boardNumber);
    }

    //    게시글 추가
    public int save(BoardVO boardVO) {
        return boardMapper.insert(boardVO);
    }

    //    게시글 수정
    public int setBoard(BoardVO boardVO) {
        return boardMapper.update(boardVO);
    }

    //    게시글 삭제
    public int deleteById(Long boardNumber) {
        return boardMapper.delete(boardNumber);
    }

}









