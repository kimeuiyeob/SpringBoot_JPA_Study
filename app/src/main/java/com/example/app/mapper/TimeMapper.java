package com.example.app.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//spring은 인터페이스에 추상메소드를 만들어서 이걸로 mapper랑 연동을 시켜서 사용하는것이다.
//(mapper인터페이스에 Mapper가 주입이되는것이다) , Mapper이름이랑 인터페이스 mapper이름이랑 같게 해주는것이 안헤깔리고 좋다.

@Mapper //이게 mapper랑 연동을 시켜준다.
public interface TimeMapper {
    public String getTime();

    @Select("SELECT SYSDATE FROM DUAL")
    //짧은 쿼리문 같은경우는 Mapper를 안만들고 여기서 바로 디비연동이 가능하다. 하지만 쿼리문이 긴경우는 mapper를 사용하자!!
    public String getTimeQuick();
}
