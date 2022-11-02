package com.example.app1.mapper;


import com.example.app1.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ProductMapper {


    //select는 조회해오면 VO가 나오고 안되면 null이나옴
    public ProductVO select(Long productNumber);

    //int는 성공 1 실패0으로 나옴 , 그래서 insert,update,delete는 returnType은 int이다.
    public int insert(ProductVO productVO);

    public int update(ProductVO productVO);

    public int delete(Long productNumber);

}
