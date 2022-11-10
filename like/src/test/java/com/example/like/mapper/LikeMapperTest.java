package com.example.like.mapper;


import com.example.like.domain.likeVO.LikeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class LikeMapperTest {

    @Autowired
    private LikeMapper likeMapper;

    @Test //번호로 조회하기
    public void selectTest(Long musicNumber) {
        likeMapper.select(3L);
    }

    @Test //전체 조회하기
    public void selectAllTest() {
        likeMapper.selectAll().stream().map(LikeVO::toString).forEach(log::info);
    }


}
