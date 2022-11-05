package com.example.app.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomError implements ErrorController { /*ErrorController 내장되어있는 인터페잇가 있다*/

    /*내가 설정한 페이지 경로말고 수많은 잘못된 경로및 오류로 경로가 잡히면 여기로 들어온다. */
    @GetMapping("/error")
    public String handleError(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status != null){
            int statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value()){
                return "/error/404";
            }
        }
        return "/error/500";
    }
}
/*404,500 페이지 만들어서 복붙하자!!*/
