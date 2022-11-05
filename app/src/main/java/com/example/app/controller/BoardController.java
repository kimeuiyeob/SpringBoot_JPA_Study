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
@RequestMapping("/board/*") //@RequestMapping은 경로 localhost:10007/board 이렇게 잡아준다.
public class BoardController {
    private final BoardService boardService;

//    게시글 목록 (게시글 목록 전체 조회)
    @GetMapping("/list") // List<BoardVO>를 가져와 boards키값으로 넘겨준다.
    public void list(Model model){
        model.addAttribute("boards", boardService.show());
    }

//    게시글 등록
    @GetMapping("/write")
    //new BoardVO를 보낸이유는 write.html에서 field를 쓰기위해서, th:field를 쓰기위해서는 부모가있어야된다. 가보면 부모에 board를 가져왔다.
    public void write(Model model){
        model.addAttribute("board", new BoardVO());
    }

    //(게시글 추가)
    @PostMapping("/write")
    //아래 return이 RedirectView 뷰니까 타입을 이걸로 받는다.
    public RedirectView write(BoardVO boardVO, RedirectAttributes redirectAttributes){
        boardService.add(boardVO);  //게시글에 제목,내용,작성자를 쓴 새로운 VO를 보내준다.
        redirectAttributes.addFlashAttribute("boardNumber", boardVO.getBoardNumber());
        //.addFlashAttribute로 전달한 값은 url뒤에 붙지 않는다. 아래 redirect를 만나도 한번은 가져간다.

        //redirectView를 쓴 이유는 redirrect는 값을 초기화한다. 먼저 위에서 .add()를 써서 게시글을 추가해줬으니까 redirect로 초기화 해주고 list로 간다.
        //만약 값을 초기화하지 않고 list로 갈경우 list에 boardVO가 있으면 값이 충돌나거나 헤깔릴수가 있기때문에 이럴경우 redirectView로 값을 초기화 해서 보내주자!!
        return new RedirectView("list");
    }

//    게시글 수정, 게시글 상세보기
    @GetMapping(value = {"read", "update"}) //2개의 경로를 한번에 받을때는 value={ }를 사용하자!
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
























