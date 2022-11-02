package com.example.app.mapper;

import com.example.app.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //SpringBoot테스트 할때 쓰는 어노테이션
@Slf4j  //log.info 할때 쓰는 어노테이션
public class BoardMapperTest {

    @Autowired //@Autowired 주입
    private BoardMapper boardMapper;

    @Test //게시글 목록 (select)
    public void getListTest() { // List<BoardVO> getList()로 만들었기때문에 forEach사용해서 목록을 조회한다.
        boardMapper.getList().stream().map(BoardVO::toString).forEach(log::info);
    }


    @Test //게시글 추가 (insert)
    public void insertListTest() {

        BoardVO boardVO = new BoardVO(); //새롭게 추가하는거니까 boardVO객체화해주고

        boardVO.setBoardTitle("테스트제목2"); //set으로 새로운 값들을 넣어준다.
        boardVO.setBoardWriter("textB");
        boardVO.setBoardContent("테스트내용2");

        boardMapper.insert(boardVO);
        //BoardMapper인터페이스에 있는 insert()메소드를 사용해서 값을 디비에 넣어준다.

    }

    @Test //게시글 수정 (update)
    public void updateListTest() {

        BoardVO boardVO = boardMapper.getUser((long) 1); //getUser()로 게시글조회한다음 boardNumber가 1인경우

        Assertions.assertNotNull(boardVO); //오류를 알려줘 실무에서 많이쓴다.

        boardVO.setBoardTitle("테스트제목6"); //set으로 새로운 값들을 넣어준다.
        boardVO.setBoardWriter("textA");
        boardVO.setBoardContent("테스트내용6");

        boardMapper.update(boardVO);
        //BoardMapper인터페이스에 있는 update()메소드를 사용해서 값을 디비에 넣어준다.

    }


    @Test //게시글 삭제 (delete)
    public void deleteListTest() {

        boardMapper.delete((long) 7);

    }

}
