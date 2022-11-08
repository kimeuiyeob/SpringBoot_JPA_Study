package com.example.app.controller;

import com.example.app.domain.vo.BoardVO;
import com.example.app.domain.vo.Criteria;
import com.example.app.domain.vo.PageDTO;
import com.example.app.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
@Slf4j
public class BoardController {
    private final BoardService boardService;

//    게시글 목록 , 경로가 board/list일때 여기로 들어온다 -> html로 간다.
    @GetMapping("/list")
    public void list(Criteria criteria, Model model){
        PageDTO pageDTO = new PageDTO();
        if(criteria.getPage() == 0){ //만약 page가 0일시
            criteria.createCriteria(); //.createCriteria()를 실행에 page:1과 amount:10을 실행한다.
        }
        pageDTO.createPageDTO(criteria, boardService.getTotal()); //.getTotal() 게시글 넘버 전부 가져오는거.
        model.addAttribute("boards", boardService.show(criteria));
        model.addAttribute("pagination", pageDTO);
    }

//    게시글 등록 , list상단 글동록 클릭시 여기로
    @GetMapping("/write")
    public void write(Criteria criteria, Model model){
        model.addAttribute("board", new BoardVO());
    }
    // List<BoardVO>를 가져와 boards키값으로 넘겨준다.( th:object="${board} 이거 써서 *{ } 이거 쓰기 위해서 )
    // th:field는 name과 id를 해당 ${ }이값으로 자동으로 만들어준다.


    @PostMapping("/write") /*글 등록 완료하고 post방식으로 보낼때 여기로*/
    public RedirectView write(BoardVO boardVO, RedirectAttributes redirectAttributes){ /*RedirectView쓴 이유는 값을 디비에 넣어주면 초기화시키기위해*/
        boardService.add(boardVO); //.add()를 통해 디비에 insert해준다.
        redirectAttributes.addFlashAttribute("boardNumber", boardVO.getBoardNumber());
        //.addFlashAttribute로 전달한 값은 url뒤에 붙지 않는다. 아래 redirect를 만나도 한번은 가져간다. 즉 boardNumber는 일회성으로 한번 보낸다.
        return new RedirectView("list"); //초기화 시키고 list 경로로 이동 -> 게시판 목록
    }

//    게시글 수정, 게시글 상세보기
    @GetMapping(value = {"read", "update"}) /*목록에서 제목을 눌렀을시 (read)경로로 여기로*/
    public void read(Long boardNumber, Criteria criteria, Model model){
        model.addAttribute("board", boardService.find(boardNumber)); //번호로 조회한 해당 boardVO board키값으로 보낸다.
    }

    @PostMapping("/update") /*read.html에서 goUpdate()를 통해 여기 경로로 해당 번호랑 같이*/
    public RedirectView update(BoardVO boardVO, Criteria criteria, RedirectAttributes redirectAttributes){
        boardService.update(boardVO); //디비에 update를 통해 수정
//        다른 컨트롤러로 이동할 때에는 쿼리스트링으로 전달해야 한다.
        redirectAttributes.addAttribute("boardNumber", boardVO.getBoardNumber());
        redirectAttributes.addAttribute("page", criteria.getPage());
        redirectAttributes.addAttribute("amount", criteria.getAmount());
//        화면에서만 사용할 때에는 Flash영역을 사용하여 전달해야 한다.
//        redirectAttributes.addFlashAttribute("boardNumber", boardVO.getBoardNumber());
        return new RedirectView("/board/read");
    }

//    게시글 삭제
    @PostMapping("/delete") /*read.html에서 board/delete에다 post방식으로 submit해서 여기로*/
    public RedirectView delete(Long boardNumber){ //delete도 RedirectView를 통해 디비에 delete를 하면 값을 초기화한다.
        boardService.delete(boardNumber); //디비에 delete로 값 삭제
        return new RedirectView("/board/list"); //그다음에 초기화된 상태로 board/list로 경로 쏴준다. -> 목록
    }
}
























