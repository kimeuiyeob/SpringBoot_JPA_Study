package com.example.app1.service;


import com.example.app1.domain.dao.ProductDAO;
import com.example.app1.domain.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //ProductService인터페이스를 ProductServiceImpl에서 구현해주었다.
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Override //번호로 조회
    public ProductVO find(Long productNumber) {
        return productDAO.find(productNumber);
    }

    @Override //추가
    public boolean add(ProductVO productVO) {
        return productDAO.save(productVO) == 1;
    }

    @Override //수정
    public boolean update(ProductVO productVO) {
        return productDAO.set(productVO)==1;
    }

    @Override //삭제
    public boolean delete(Long productNumber) {
        return productDAO.delete(productNumber)==1;
    }
}
