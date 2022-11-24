package com.example.basic.domain.entity;

import com.example.basic.repository.MemberDAO;
import com.example.basic.type.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class MemberTest {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void saveTest(){
        Member memberA = new Member();
        Member memberB = new Member();

        memberA.setMemberName("한동석");
        memberA.setMemberEmail("tedhan1204@gmail.com");
        memberA.setMemberPassword("1234");
        memberA.setMemberAge(20);
        memberA.setMemberType(MemberType.MEMBER);

        memberB.setMemberName("장선홍");
        memberB.setMemberEmail("jsh0419@gmail.com");
        memberB.setMemberPassword("5060");
        memberB.setMemberAge(20);
        memberB.setMemberType(MemberType.ADMIN);

        memberDAO.save(memberA);
        memberDAO.save(memberB);
    }

    @Test
    public void deleteTest(){
        memberDAO.delete(memberDAO.findById(2L));
    }

    @Test
    public void findByIdTest(){
        log.info("member: " + Optional.ofNullable(memberDAO.findById(2L)).orElseGet(Member::new));
    }
}










