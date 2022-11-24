package com.example.basic.domain.entity;

import com.example.basic.type.MemberType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_MEMBER")
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long memberId;
    @Column(name = "MEMBER_NAME")
    private String memberName;
    @Column(name = "MEMBER_EMAIL", unique = true)
    private String memberEmail;
    @Column(name = "MEMBER_PASSWORD")
    private String memberPassword;
    @Column(name = "MEMBER_AGE")
    private int memberAge;
    @Enumerated(EnumType.STRING)
    @Column(name = "MEMBER_TYPE")
    private MemberType memberType;

    public void create(String memberName, String memberEmail, String memberPassword, int memberAge, MemberType memberType) {
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberAge = memberAge;
        this.memberType = memberType;
    }
}


















