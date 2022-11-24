package com.example.basic.repository;

import com.example.basic.domain.entity.SuperCar;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class SuperCarDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public SuperCar save(SuperCar superCar){
        entityManager.persist(superCar);
        return entityManager.find(SuperCar.class, superCar.getSuperCarId());
    }

    public void delete(SuperCar superCar){
        entityManager.remove(superCar);
    }

//    조회 시 NPE를 방어하기 위해 Optional로 리턴한다.
    public Optional<SuperCar> findById(Long superCarId){
        return Optional.ofNullable(entityManager.find(SuperCar.class, superCarId));
    }

    public List<SuperCar> findAll(){
//        한 개의 데이터를 조회할 때에는 JPA가 find()를 제공하지만 전체를 조회할 때에는 JPA가 제공하는 JPQL을 사용해야 한다.
//        SQL문 뒤에는 결과 중 한 개 행에 대한 resultType을 작성해준다. 여러 개 행을 가져올 때에는 getResultList()를 사용한다.

//        ▶ JPQL 주의사항
//        1. 엔티티명과 필드명은 대소문자를 구분한다.
//        2. JPQL 키워드는 대소문자를 구분하지 않는다.
//        3. JPQL에서 사용하는 테이블명은 클래스명이 아닌 엔티티명이다.
//        4. 엔티티의 Alias는 필수로 작성해야 한다.
        return entityManager.createQuery("select s from SuperCar s", SuperCar.class).getResultList();
    }

    public Long getCountOfSuperCar(){
        return entityManager.createQuery("select count(s) from SuperCar s", Long.class).getSingleResult();
    }

//    파라미터 바인딩
    public List<SuperCar> findSuperCarByReleaseDate(String superCarReleaseDate){
        return entityManager.createQuery("select s from SuperCar s where function('to_char', s.superCarReleaseDate, 'yyyyMMdd') = :superCarReleaseDate")
                .setParameter("superCarReleaseDate", superCarReleaseDate).getResultList();
    }

    public List<SuperCar> findSuperCarByColorContaining(String superCarColor){
        return entityManager.createQuery("select s from SuperCar s where s.superCarColor like :keyword")
                .setParameter("keyword", "%" + superCarColor + "%").getResultList();
    }

//    실습
//    시작 날짜와 종료 날짜를 전달받은 뒤 해당 기간 내에 출시된 슈퍼카 목록 전체 조회
    public List<SuperCar> findSuperCarBetweenReleaseDate(LocalDateTime startDate, LocalDateTime endDate){
        return entityManager.createQuery("select s from SuperCar s where s.superCarReleaseDate between :startDate and :endDate")
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }

//    페이징
    public List<SuperCar> findAllPaging(int offset, int limit){
        String q = "select s from SuperCar s order by s.superCarId desc";
        return entityManager.createQuery(q, SuperCar.class)
                .setFirstResult(offset) //0부터 시작
                .setMaxResults(limit)
                .getResultList();
    }
//    수정 (벌크 연산), 영속성 컨텍스트를 무시하고 SQL 반영
    public int bulkUpdate(String superCarReleaseDate){
        String q = "update SuperCar s set s.superCarPrice = s.superCarPrice * 1.1 where function('to_char', s.superCarReleaseDate, 'yyyyMMdd') = :superCarReleaseDate";
        return entityManager.createQuery(q).setParameter("superCarReleaseDate", superCarReleaseDate).executeUpdate();
    }
}











