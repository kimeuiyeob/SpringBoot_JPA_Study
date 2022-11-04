package com.example.prac.mapper;

import com.example.prac.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    //    추가
    public void insert(ProductVO productVO);
    //    수정
    public void update(ProductVO productVO);
    //    조회
    public ProductVO select(Long productNumber);
    //    전체 조회
    public List<ProductVO> selectAll();
    

}
