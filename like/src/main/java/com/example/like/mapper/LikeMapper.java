package com.example.like.mapper;

import com.example.like.domain.likeVO.LikeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikeMapper {

    //전체 조회
    public List<LikeVO> select();

    //번호로 조회
    public LikeVO selectAll (Long musicNumber);


}
