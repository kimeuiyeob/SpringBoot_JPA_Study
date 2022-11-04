package com.example.app1.controller;


import com.example.app1.domain.vo.ProductVO;
import com.example.app1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    //상품 추가
    @GetMapping("/put")
    public void put(){}

    @PostMapping("/put")
    public void put(ProductVO productVO) {
        productService.add(productVO);
    }

    //상품 수정
    @GetMapping("/change")
    public void change(Long productNumber, Model model) {model.addAttribute("product",productService.find(productNumber));
    }

    @PostMapping("/change")
    public RedirectView change(ProductVO productVO, RedirectAttributes redirectAttributes) {
        productService.update(productVO);
        redirectAttributes.addAttribute("productNumber",productVO.getProductNumber());
        return new RedirectView("/ex/change");
    }


    //상품 삭제
    @PostMapping("/delete")
    public RedirectView delete(Long productNumber) {
        productService.delete(productNumber);
        return new RedirectView("/ex/delete");
    }







}
