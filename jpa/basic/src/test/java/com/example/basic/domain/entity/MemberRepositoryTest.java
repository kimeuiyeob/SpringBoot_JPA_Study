package com.example.basic.domain.entity;

import com.example.basic.repository.MemberRepository;
import com.example.basic.type.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void saveTest(){
        Member member1 = new Member();
        Member member2 = new Member();
        member1.create("한동석", "tedhan1204@gmail.com", "1234", 20, MemberType.ADMIN);
        member2.create("홍길석", "hgs1111@gmail.com", "0000", 30, MemberType.MEMBER);
        log.info("saved member: " + memberRepository.save(member1));
        log.info("saved member: " + memberRepository.save(member2));
    }

    @Test
    public void findByIdTest(){
        assertThat(memberRepository.findById(1L)).isNotEmpty();
    }

    @Test
    public void findAllTest(){
        assertThat(memberRepository.findAll().stream().map(Member::getMemberName).collect(Collectors.toList()).get(0)).isEqualTo("한동석");
    }

    @Test
    public void updateTest(){
        memberRepository.findById(1L).get().setMemberPassword("1234");
    }

    @Test
    public void deleteTest(){
        memberRepository.deleteById(1L);
    }

    @Test
    public void findByMemberNameContainingTest(){
        memberRepository.findByMemberNameContaining("석").stream().map(Member::toString).forEach(log::info);
    }

    @Test
    public void findByMemberNameStartingWithTest(){
        memberRepository.findByMemberNameStartingWith("석").stream().map(Member::toString).forEach(log::info);
    }

    @Test
    public void findByMemberNameEndingWithTest(){
        memberRepository.findByMemberNameEndingWith("석").stream().map(Member::toString).forEach(log::info);
    }

    @Test
    public void findTest(){
        memberRepository.find("%석").stream().map(Member::toString).forEach(log::info);
    }

    @Test
    public void findMemberByMemberAgeTest(){
        memberRepository.findMemberByMemberAge(MemberType.MEMBER, 20).stream().map(Member::toString).forEach(log::info);
    }

    @Test
    public void findMemberByNamesTest(){
        memberRepository.findMemberByNames(Arrays.asList("한동석", "홍길석")).stream().map(Member::toString).forEach(log::info);
    }

    @Test
    public void updateByNameTest(){
        Member member = memberRepository.findById(3L).get();
        memberRepository.updateByName(20);
        member = memberRepository.findById(3L).get();
        assertThat(member.getMemberAge()).isEqualTo(23);
    }

    @Test
    public void deleteByAgeTest(){
        Member member = memberRepository.findById(2L).get();
        memberRepository.deleteByAge(20);
        log.info("isPresent: " + memberRepository.findById(2L).isPresent());
    }
}




















