package com.example.advanced.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_PET")
@Getter @Setter @ToString(exclude = "owner")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pet {
    @Id @GeneratedValue
    private Long petId;
    private String petName;
    private String petGender;
    private String petDisease;
//    @???ToOne일 경우 기본 fetch 타입은 EAGER이다.
//    EAGER는 즉시로딩이며, 한 번에 조인하여 전체 연관 객체를 가져온다.
//    하지만 복잡한 연관관계 속에서 EAGER를 사용하면 불필요한 조인이 발생하기 때문에 성능 이슈가 생길 수 있다.
//    따라서 실무에서는 반드시 모든 연관관계에 있어서 LAZY 즉, 지연 로딩으로 설정해서 사용해야 한다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;
}
