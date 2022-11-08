package com.example.music.domain.dao;


import com.example.music.domain.vo.MusicVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MusicDAOTest {

    @Autowired
    private MusicDAO musicDAO;

    @Test //음악 전체 목록 조회
    public void findAllTest() {
        musicDAO.findAll().stream().map(MusicVO::toString).forEach(log::info);
    }

    @Test //음악 번호로 조회
    public void findByNumbeTest() {
        musicDAO.findByNumber(19L);
    }

    @Test //음악 추가
    public void saveTest() {
        MusicVO musicVO = new MusicVO();
        musicVO.setMusicTitle("나는야 제목");
        musicVO.setMusicSinger("나는야 가수 이름");
        musicVO.setMusicLyrics("나는야 노래 가사");
        musicDAO.save(musicVO);
    }

    @Test //음악 수정
    public void setMusicTest() {
        MusicVO musicVO = musicDAO.findByNumber(1L);
        musicVO.setMusicTitle("내가 1번 제목 수정함ㅎㅎ");
        musicVO.setMusicSinger("내가 1번 제목 수정함ㅎㅎ");
        musicVO.setMusicLyrics("내가 1번 제목 수정함ㅎㅎ");
        musicDAO.setMusic(musicVO);
    }

    @Test //음악 삭제
    public void deleteByNumberTest() {
        musicDAO.deleteByNumber(1L);
    }

    @Test //김씨가 부른 음악 조회
    public void findByNameTest() {
        musicDAO.findByName();
    }

}
