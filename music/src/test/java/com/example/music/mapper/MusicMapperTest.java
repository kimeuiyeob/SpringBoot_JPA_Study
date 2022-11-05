package com.example.music.mapper;


import com.example.music.domain.vo.MusicVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MusicMapperTest {

    @Autowired
    private MusicMapper musicMapper;

    @Test //음악 전체 조회
    public void getListTest() {
        musicMapper.getList().stream().map(MusicVO::toString).forEach(log::info);
    }

    @Test //음악 번호로 해당 조회
    public void selectTest() {
        musicMapper.select(12L);
    };

    @Test
    public void insertTest() {
        MusicVO musicVO = new MusicVO();
        musicVO.setMusicTitle("Marry Me");
        musicVO.setMusicSinger("김필");
        musicVO.setMusicLyrics("메리이이이이이미 ~ 그댈 사랑할께요~~~~~~~~~~~~오오오오 메리미미미이이");
        musicMapper.insert(musicVO);
    }

    @Test
    public void updateTest() {
        MusicVO musicVO = musicMapper.select(12L);
        musicVO.setMusicTitle("누군가의");
        musicVO.setMusicSinger("노래를");
        musicVO.setMusicLyrics("내가수정해버렸지ㅎㅎㅎㅎㅎ");
        musicMapper.update(musicVO);
    }

    @Test
    public void deleteTest() {
        musicMapper.delete(12L);
    }

    @Test
    public void selectWithTest() {
        musicMapper.selectWith().stream().map(MusicVO::toString).forEach(log::info);
    }

}
