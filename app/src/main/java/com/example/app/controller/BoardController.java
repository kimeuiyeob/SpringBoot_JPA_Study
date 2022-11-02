package com.example.app.controller;

import com.example.app.domain.vo.BoardVO;
import com.example.app.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    private final BoardService boardService;

    //    게시글 목록
    @GetMapping("/list")
    public void list(Model model){
        model.addAttribute("boards", boardService.show());
    }

    //    게시글 등록
    @GetMapping("/write")
    public void write(){}

    @PostMapping("/write")
    public void write(BoardVO boardVO){
        boardService.add(boardVO);
    }

    //    게시글 수정, 게시글 상세보기
    @GetMapping(value = {"read", "update"})
    public void read(Long boardNumber, Model model){
        model.addAttribute("board", boardService.find(boardNumber));
    }

    @PostMapping("/update")
    public RedirectView update(BoardVO boardVO, RedirectAttributes redirectAttributes){
        boardService.update(boardVO);
//        다른 컨트롤러로 이동할 때에는 쿼리스트링으로 전달해야 한다.
        redirectAttributes.addAttribute("boardNumber", boardVO.getBoardNumber());
//        화면에서만 사용할 때에는 Flash영역을 사용하여 전달해야 한다.
//        redirectAttributes.addFlashAttribute("boardNumber", boardVO.getBoardNumber());
        return new RedirectView("/board/read");
    }

    //    게시글 삭제
    @PostMapping("/delete")
    public RedirectView delete(Long boardNumber){
        boardService.delete(boardNumber);
        return new RedirectView("/board/list");
    }
}


