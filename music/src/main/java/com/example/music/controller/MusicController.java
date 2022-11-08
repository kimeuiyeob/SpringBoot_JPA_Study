package com.example.music.controller;

import com.example.music.domain.vo.MusicVO;
import com.example.music.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/music/*")
public class MusicController {

    private final MusicService musicService;

    //    음악 전체 목록 조회
    @GetMapping("/list")
    public void list(Model model) {
        model.addAttribute("music",musicService.show());
    }


/*=====================================================================================================*/

    // 음악 번호로 노래 찾기
    @GetMapping("/number")
    public void number(Model model) {
        model.addAttribute("music",musicService.findNumber(20L));
    }
    @PostMapping("/numberFind")
    public void numberFind(Model model){
        model.addAttribute("music",musicService.findNumber(20L));
    }

    /*=====================================================================================================*/


    //    음악 추가
    @GetMapping("/write")
    public void write(Model model) {
        model.addAttribute("music",new MusicVO());
    }

    @PostMapping("/write")
    public RedirectView write(MusicVO musicVO, RedirectAttributes redirectAttributes) {
        musicService.add(musicVO);
        redirectAttributes.addFlashAttribute("musicNumber",musicVO.getMusicNumber());
        return new RedirectView("list");
    }

    //    제목 클릭 -> 음악 수정 , 음악 목록 상세보기
    @GetMapping(value={"read","update"})
    public void read(Long musicNumber,Model model) {
        model.addAttribute("music",musicService.findNumber(musicNumber));
    }

    @PostMapping("/update")
    public RedirectView update(MusicVO musicVO, RedirectAttributes redirectAttributes) {
        musicService.update(musicVO);
        redirectAttributes.addAttribute("musicNumber",musicVO.getMusicNumber());
        return new RedirectView("/music/read");
    }

    //    음악 해당 번호로 삭제

    @PostMapping("/delete")
    public RedirectView delete(Long musicNumber){
        musicService.delete(musicNumber);
        return new RedirectView("/music/list");
    }

    //    김씨가 부른 음악 조회
    @GetMapping("/kim")
    public void kim(Model model) {
        model.addAttribute("music",musicService.showByName());
    }

}
