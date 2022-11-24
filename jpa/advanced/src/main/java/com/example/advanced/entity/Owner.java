package com.example.advanced.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_OWNER")
@Getter @Setter @ToString(exclude = "pets")
// 무분별한 생성을 막기 위해서 public보다는 protected로 설정하고, Spring에서 관리되는 대상이므로 private은 적절하지 않다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Owner {
    @Id @GeneratedValue
    private Long ownerId;
    private String ownerName;
    @Column(unique = true)
    private String ownerPhone;
    private Integer ownerAge;

//    다대일 양방향 관계
//    양방향에서는 연관관계의 주인을 정해야 한다.
//    DBMS에서는 FK로 양방향 조회가 가능하지만, 객체에서는 객체 간 참조 2개인 단방향 2개로 설정된다.
//    만약 주인을 정해주지 않으면, DBMS쪽에서는 2개의 연관관계인지, 하나의 연관관계를 단방향 2개로 설정한건지 알 수가 없다.
//    영속성 컨텍스트도 복잡해질 수 있으며, 불필요한 중간 테이블이 생성될 수도 있기 때문에
//    하나의 연관관계에서 양방향 설계 시 하나의 객체에서만 FK를 관리해야 한다.
//    이 때 FK를 관리하는 객체를 연관관계의 주인이라고 하며, Pet엔티티에서 FK(owner_number)를 관리하는 객체는 owner이다.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Pet> pets;
}



















