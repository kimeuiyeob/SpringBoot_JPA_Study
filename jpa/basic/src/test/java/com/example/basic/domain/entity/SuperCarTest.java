package com.example.basic.domain.entity;

import com.example.basic.repository.SuperCarDAO;
import com.example.basic.type.SuperCarBrand;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class SuperCarTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SuperCarDAO superCarDAO;

    @Test
    public void saveTest(){
//        SuperCar bentley = new SuperCar();
//        SuperCar lamborghini = new SuperCar();
//        LocalDateTime bentleyReleaseDate = LocalDateTime.of(2019, 12, 4, 0, 0);
//        LocalDateTime lamborghiniReleaseDate = LocalDateTime.of(2022, 4, 25, 0, 0);
//        bentley.create(SuperCarBrand.BENTLEY, "White", "GT", 350_000_000L, bentleyReleaseDate);
//        lamborghini.create(SuperCarBrand.LAMBORGHINI, "Yellow", "Urus", 450_000_000L, lamborghiniReleaseDate);
//
//        superCarDAO.save(bentley);
//        superCarDAO.save(lamborghini);


        for (int i=0; i<100; i++){
            SuperCar superCar = new SuperCar();
            LocalDateTime superCarReleaseDate = LocalDateTime.of(2019, 12, 4, 0, 0);
            superCar.create(SuperCarBrand.BENTLEY, "White", "car" + (i + 1), 350_000_000L, superCarReleaseDate);
            superCarDAO.save(superCar);
        }

    }

    @Test
    public void deleteTest(){
        superCarDAO.delete(superCarDAO.findById(2L).get());
    }

    @Test
    public void findAllTest(){
        superCarDAO.findAll().stream().map(SuperCar::toString).forEach(log::info);
    }

    @Test
    public void getCountOfSuperCarTest(){
        log.info("count: " + superCarDAO.getCountOfSuperCar());
    }

    @Test
    public void findSuperCarByReleaseDateTest(){
        LocalDateTime releaseDate = LocalDateTime.of(2022, 4, 25, 0, 0);
        String format = releaseDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        superCarDAO.findSuperCarByReleaseDate(format).stream().map(SuperCar::getSuperCarName).forEach(log::info);
    }

    @Test
    public void findSuperCarByColorContainingTest(){
        superCarDAO.findSuperCarByColorContaining("e").stream().map(SuperCar::getSuperCarBrand).forEach(brand -> {
            log.info("brand: " + brand);
        });
        assertThat(superCarDAO.findSuperCarByColorContaining("e").stream().map(SuperCar::getSuperCarBrand).collect(Collectors.toList()).get(0).name()).isEqualTo("BENTLEY");
    }

    @Test
    public void findSuperCarBetweenReleaseDateTest(){
        LocalDateTime startDate = LocalDateTime.of(2019, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 0, 0);
//        Assertions.assertThat(superCarDAO.findSuperCarBetweenReleaseDate(startDate,endDate).get(0).getSuperCarBrand()).isEqualTo(SuperCarBrand.LAMBORGHINI);
        assertThat(superCarDAO.findSuperCarBetweenReleaseDate(startDate,endDate).get(0).getSuperCarBrand()).isEqualTo(SuperCarBrand.BENTLEY);
    }

    @Test
    public void findAllPagingTest(){
        superCarDAO.findAllPaging(10, 10).stream().map(SuperCar::getSuperCarName).forEach(log::info);
    }

    @Test
    public void bulkUpdateTest(){
//        List<SuperCar> superCars = superCarDAO.findAllPaging(0, 10);
        String q1 = "select s from SuperCar s order by s.superCarId desc";
        List<SuperCar> superCars = entityManager.createQuery(q1, SuperCar.class)
                .setFirstResult(0) //0부터 시작
                .setMaxResults(10)
                .getResultList();

        String superCarReleaseDate = LocalDateTime.of(2019, 12, 4, 0, 0).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//        log.info("count: " + superCarDAO.bulkUpdate());

        String q2 = "update SuperCar s set s.superCarPrice = s.superCarPrice * 1.1 where function('to_char', s.superCarReleaseDate, 'yyyyMMdd') = :superCarReleaseDate";
        entityManager.createQuery(q2).setParameter("superCarReleaseDate", superCarReleaseDate).executeUpdate();

//        벌크 연산 수행 시 영속성 컨텍스트 모르게 SQL문이 실행되기 떄문에 객체진영과 RDB진영 간의 데이터 불일치가 발생한다.
//        만약 동일한 트랜잭션에서 벌크 연산을 수행하게 된다면, 반드시 벌크 연산 후 영속성 컨텍스트를 비워줘야 한다.
        entityManager.clear();

        superCars.stream().forEach(superCar -> {log.info(superCar.getSuperCarName() + " price: " + superCar.getSuperCarPrice());});

    }
}















