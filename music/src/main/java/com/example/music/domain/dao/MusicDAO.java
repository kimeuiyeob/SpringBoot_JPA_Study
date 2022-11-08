package com.example.music.domain.dao;


import com.example.music.domain.vo.MusicVO;
import com.example.music.mapper.MusicMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MusicDAO {

    private final MusicMapper musicMapper;

    //    음악 전체 목록 조회
        public List<MusicVO> findAll() {
            return musicMapper.getList();
        }

    //    음악 번호로 조회
        public MusicVO findByNumber(Long musicNumber) {
            return musicMapper.select(musicNumber);
        }

    //    음악 추가
        public void save(MusicVO musicVO) {
            musicMapper.insert(musicVO);
        }

    //    음악 수정
        public void setMusic(MusicVO musicVO) {
            musicMapper.update(musicVO);
        }

    //    음악 삭제
        public void deleteByNumber(Long musicNumber) {
            musicMapper.delete(musicNumber);
        }

    //    김씨가 부른 음악 조회
        public List<MusicVO> findByName() {
            return musicMapper.selectWith();
        }

}
