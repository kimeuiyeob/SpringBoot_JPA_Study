package com.example.ex00.dependency;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //이클래스 너가 관리해줘 VO,DTO에 붙임, Spring 등록하기
//@Data //롬복에서 Data는 다 만들어준다.
@Getter
@ToString
//@Setter는 나중에 필요할때

//아래3개 생성자 종류
//@NoArgsConstructor //기본 생성자
//@AllArgsConstructor //모든걸해주는 생성자
@RequiredArgsConstructor //final이 붙어있거나 NonNull이 붙어있으면 생성자로 초기화시켜준다, 필요한거 골라서 하는 생성자

public class Coding {
    //필드 주입
    //굉장히 편하게 주입할 수 있으나 순환 참조시 오류가 발생하지 않기 때문에 StatckOverFlow 발생.
    //final을 붙일 수 없기 때문에 다른곳에서 변경 가능
//    @Autowired //주입해줘 ,내가 new할거아니야 ,이렇게 하면 필드주입(하지 않기 -> StatckOverFlow 발생)
//    @NonNull //null이면 안된다.
//    final이 붙으면 반드시 초기화 생성을 해줘야한다, requiredArgue가 초기화 생성자를 만들어준다.
    private final Computer computer;

    //생성자 주입 (생성자 주입을 쓰자!!)
    //순환참조시 컴파일러 인지 가능, 오류 발생
    //메모리 할당되면서 초기값으로 주입되므로 final 키워드 사용 가능, 다른곳에서 변형 불가능
    //의존성 주입이 안되면 객체가 생성되지 않으므로 NPE 방어
    //생성자에 @Autowired생략 가능
//    @Autowired //이것도 롬복이 알아서해준다.
//    public Coding(Computer computer) {
//        this.computer = computer;
//    }
}
















