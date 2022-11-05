package com.example.app.mapper;

import com.example.app.domain.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
//    게시글 전체 목록 조회
    public List<BoardVO> getList();
//    게시글 번호로 조회
    public BoardVO select(Long boardNumber);
//    게시글 추가
    public int insert(BoardVO boardVO);
//    게시글 수정
    public int update(BoardVO boardVO);
//    게시글 삭제
    public int delete(Long boardNumber);
}
