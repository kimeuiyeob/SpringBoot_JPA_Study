package com.example.ex02.controller;


import com.example.ex02.domain.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller //Spring MVC에서 Controller클래스에 쓰인다.
@Slf4j //log.info 사용 가능
@RequestMapping("/ex/*") // spring에서는 앞에서부터 찾는다. 경로앞에 ex가붙으면 다여기로 매핑해준다.
//@RequestMapping요청 URL을 어떤 method가 처리할지 mapping해주는 Annotation이다.
public class ExampleController {

    @RequestMapping(value = "ex01", method = {RequestMethod.GET, RequestMethod.POST})
    //method를 쓰지 않는다면 default get방식으로 전달한다.
    public void ex01() {
        log.info("ex01...........");
    }

    @GetMapping("ex02") //get방식 매핑
    public void ex02(HttpServletRequest request) {
        log.info("name: " + request.getParameter("name"));
    }

    @GetMapping("ex03")
    public void ex03(String name) {
        log.info("name: " + name);
    }

    @GetMapping("ex04")
    public void ex04(MemberVO memberVO) {
        log.info("member: " + memberVO);
    }

    @GetMapping("ex05")
    public void ex05(@RequestParam("id") String name, int age) {
        log.info("name: " + name);
        log.info("age " + age);
    }

    @GetMapping("/ex06")
    public void ex06(MemberVO memberVO) {
        log.info("ex06..............");
    }

    @GetMapping("ex07")
    public void ex07(@ModelAttribute("gender") String gender, MemberVO memberVO) {
        log.info("ex07..............");
        log.info("memberVO: " + memberVO);
        log.info("gender: " + gender);

    }
    //===============================================================================

    //외부에서 상품명, 상품가격, 상품재고, 브랜드 전달받아서 화면에서 전송
    //화면에서 4개정보 입력후 form태그로 전송한다.

    @GetMapping("ex08")
    public void ex08() {
        log.info("ex08..............");
    }

    @GetMapping("ex09")
    public void ex09(ProductVO productVO) {
        log.info("ex09..............");
        log.info("productVO: " + productVO);
    }
    //===============================================================================

    //    TaskVO 선언
    //    int num, int kor, int eng, int math 선언
    //    총점과 평균 점수 화면에 출력

    @GetMapping("ex10")
    public String ex10() {
        return "ex/ex10";
    }

    @PostMapping("ex11")
    public String ex11(TaskVO taskVO, Model model) {
        return "ex/ex11";
    }


    //===============================================================================

    //    아이디와 비밀번호를 입력받은 후 아이디가 admin일 경우 admin.html로 이동
    //    아이디가 user일 경우 user.html로 이동
    //    - login.html : 아이디와 비밀번호 입력 페이지 출력
    //    - admin.html : 관리자 페이지 출력
    //    - user.html : 일반 회원 페이지 출력

    @GetMapping("/login") //요청받은 경로에 login이 왔다면
    public String goLoginForm() {
        return "ex/login"; //login.html로 보내준다.
    }

    @PostMapping("/login") //login.html에서 post방식으로 보낸걸 여기서 받아서 연산한다.
    public String login(@ModelAttribute("id") String id, String pw) {
        //@ModelAttributeview에서 전달해주는 parameter를 Class(VO/DTO)의 멤버 변수로 binding 해주는 Annotation이다.
        if (id.equals("admin")) {
            return "ex/admin"; //admin.html경로 , returnd에서는 ex/이거 다시 붙여줘야하나보다.
        } else if (id.equals("user")) {
            return "ex/user"; //user.html경로
        }
        return "ex/login"; //아이디에 admin이나 user을 치지 않았다면 원래 경로로 return
    }

    //===============================================================================

    //외부에서 동물원 명, 동물 종류, 동물 숫자, 동물 먹이 전달 받아서 화면에서 전송
    //화면에서 4개정보 입력후 form태그로 전송한다.

    @GetMapping("/zoo")
    public String goZooForm() {
        return "ex/zoo";
    }

    @GetMapping("/zooInfo")
    public String zooInfo(ZooVO zooVO) {
        return "ex/zooInfo";
    }

    //===============================================================================

    //    ScoreVO 선언
    //    int koreaScore, int englishScore, int mathScore, int historyScore 선언
    //    총점과 평균 점수 화면에 출력

    @GetMapping("score")
    public String scoreForm() {
        return "ex/score";
    }

    @PostMapping("score")
    public String scoreResult(ScoreVO scoreVO) {
        return "ex/scoreResult";
    }


}
