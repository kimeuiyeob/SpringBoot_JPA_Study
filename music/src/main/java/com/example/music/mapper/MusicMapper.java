package com.example.music.mapper;

import com.example.music.domain.vo.MusicVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicMapper {

//    음악 전체 목록 조회
    public List<MusicVO> getList();

//    음악 번호로 조회
    public MusicVO select(Long musicNumber);

//    음악 추가
    public void insert(MusicVO musicVO);

//    음악 수정
    public void update(MusicVO musicVO);

//    음악 삭제
    public void delete(Long boardNumber);

//    김씨가 부른 음악 조회
    public List<MusicVO> selectWith();

}
