package com.example.app1.domain.dao;


import com.example.app1.domain.vo.ProductVO;
import com.example.app1.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductDAO {

    private final ProductMapper productMapper;

    //select
    public ProductVO find(Long producctNumber) {
        return productMapper.select(producctNumber);
    }

    //insert
    public int save(ProductVO productVO) {
        return productMapper.insert(productVO);
    }

    //update
    public int set(ProductVO productVO) {
        return productMapper.update(productVO);
    }

    //delete
    public int delete(Long productNumber) {
        return productMapper.delete(productNumber);
    }

}
