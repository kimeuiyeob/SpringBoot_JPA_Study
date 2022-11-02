package com.example.app.mapper;

import com.example.app.domain.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //Mapper인터페이스에서는 @Mapper어노테이션을 설정해줘서 Mapper랑 연결시킨다.
public interface BoardMapper {

    //    ***게시글 목록*** (전체 목록 가져오는거) 그래서 List로 가져와 뿌릴때에도 forEach로 뿌르는것을 알수있다.
    //    List안에는 수많은 BoardVO가 들어가 있다.
    public List<BoardVO> getList();


    //    ***게시글 조회***
    //    boardNumber가 같은 게시글을 찾아 조회한다.
    public BoardVO getUser(Long boardNumber);


    //    ***게시글 추가*** 아래 값이 4개 있어서 VO로 받는다.
    //    (게시글 해당 값들 (SEQ_BOARD.NEXTVAL, #{boardTitle}, #{boardWriter}, #{boardContent})을 넣어준다.
    public int insert(BoardVO boardVO);


    //    ***게시글 수정*** boardNumber가 같은 컬럼을 찾아서 아래 3가지 값들을 수정해준다.
    //    BOARD_TITLE = #{boardTitle}, BOARD_CONTENT = #{boardContent}, BOARD_UPDATE_DATE = SYSDATE
    public int update(BoardVO boardVO);


    //    ***게시글 삭제***
    //    boardNumber가 같으면 해당 게시글을 삭제한다.
    public int delete(Long boardNumber);

}