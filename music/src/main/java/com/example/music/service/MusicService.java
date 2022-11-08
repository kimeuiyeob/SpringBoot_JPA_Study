package com.example.music.service;


import com.example.music.domain.dao.MusicDAO;
import com.example.music.domain.vo.MusicVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicDAO musicDAO;

    //    음악 전체 목록 조회
    public List<MusicVO> show() {
        return musicDAO.findAll();
    }

    //    음악 번호로 조회
    public MusicVO findNumber(Long musicNumber) {
        return musicDAO.findByNumber(musicNumber);
    }

    //    음악 추가
    public void add (MusicVO musicVO) {
        musicDAO.save(musicVO);
    }

    //    음악 수정
    public void update(MusicVO musicVO) {
        musicDAO.setMusic(musicVO);
    }

    //    음악 해당 번호로 삭제
    public void delete(Long musicNumber) {
        musicDAO.deleteByNumber(musicNumber);
    }

    //    김씨가 부른 음악 조회
    public List<MusicVO> showByName () {
        return musicDAO.findByName();
    }


}
