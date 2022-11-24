package com.example.basic.repository;

import com.example.basic.domain.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public Member save(Member member){
        entityManager.persist(member);
        return member;
    }

    public void delete(Member member){
        entityManager.remove(member);
    }

    public Member findById(Long memberId){
        return entityManager.find(Member.class, memberId);
    }
}
