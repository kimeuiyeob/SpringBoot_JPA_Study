package com.example.app1.service;


import com.example.app1.domain.vo.ProductVO;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    public ProductVO find(Long productNumber); //번호로 조회

    public boolean add(ProductVO productVO); //추가

    public boolean update(ProductVO productVO); //수정

    public boolean delete(Long productNumber); //삭제

}
