package com.example.app.domain.dao;

import com.example.app.domain.vo.BoardVO;
import com.example.app.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //DAO에서는 Repository 어노테이션 사용!! DAO는 좀다르니까 외우자!!
@RequiredArgsConstructor //생성자 주입
public class BoardDAO {

    private final BoardMapper boardMapper;

    // DAO에서는 좀더 자바스러운 메소드 이름을 쓴다.
    // 대체적으로 select는 find를 쓰고, insert는 save, update는 set, delete는 delete를 사용한다.

    //    게시글 목록
    public List<BoardVO> findAll() {
        return boardMapper.getList();
    }


    //    게시글 조회
    public BoardVO findById(Long boardNumber) {
        return boardMapper.getUser(boardNumber);
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
