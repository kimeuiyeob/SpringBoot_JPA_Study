package com.example.music.service;

import com.example.music.domain.vo.MusicVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MusicServiceTest {

    @Autowired
    private MusicService musicService;

    @Test //음악 전체 목록 조회
    public void showTest() {
        musicService.show();
    }

    @Test // 음악 번호로 조회
    public void findNumberTest() {
        musicService.findNumber(13L);
    }

    @Test // 음악 추가
    public void addTest() {
        MusicVO musicVO = new MusicVO();
        musicVO.setMusicTitle("나는야 새로운 제목");
        musicVO.setMusicSinger("나는야 새로운 가수");
        musicVO.setMusicLyrics("나는야 새로운 가사");
        musicService.add(musicVO);
    }

    @Test // 음악 수정
    public void updateTest() {
        MusicVO musicVO = musicService.findNumber(21L);
        musicVO.setMusicTitle("나는야 수정한 제목");
        musicVO.setMusicSinger("나는야 수정한 가수");
        musicVO.setMusicLyrics("나는야 수정한 가사");
    }

    @Test //음악 해당 번호로 삭제
    public void deleteTest() {
        musicService.delete(21L);
    }

    @Test //김씨가 부른 음악 조회
    public void showByNameTest() {
        musicService.showByName();
    }

}
