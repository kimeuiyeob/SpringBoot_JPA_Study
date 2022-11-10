package com.example.app.mapper;

import com.example.app.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
//    추가
    public void insert(ReplyVO replyVO);
//    목록
    public List<ReplyVO> selectAll(Long boardNumber);
//    수정
    public void update(ReplyVO replyVO);
//    삭제
    public void delete(Long replyNumber);
//    전체 개수
    public int selectCountOfReply(Long boardNumber);
}
