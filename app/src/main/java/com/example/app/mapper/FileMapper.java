package com.example.app.mapper;

import com.example.app.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {

//    추가
    public void insert(FileVO fileVO);
//    게시글 번호로 전체 조회 /*게시글의 파일들은 여러개일수가 있으니가 List타입으로 받는다.*/
    public List<FileVO> select(Long boardNumber);
//    삭제
    public void delete(Long boardNumber);

}
