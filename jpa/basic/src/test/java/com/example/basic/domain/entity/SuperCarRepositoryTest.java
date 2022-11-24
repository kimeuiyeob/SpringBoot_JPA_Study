package com.example.basic.domain.entity;


import com.example.basic.repository.MemberRepository;
import com.example.basic.repository.SuperCarRepository;
import com.example.basic.type.MemberType;
import com.example.basic.type.SuperCarBrand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class SuperCarRepositoryTest {

    @Autowired
    private SuperCarRepository superCarRepository;

    @Test
    public void saveTest(){

        SuperCar superCar1 = new SuperCar();
        SuperCar superCar2 = new SuperCar();
        SuperCar superCar3 = new SuperCar();

        LocalDateTime superCar1ReleaseDate = LocalDateTime.of(2019, 12, 4, 0, 0);
        LocalDateTime superCar2ReleaseDate = LocalDateTime.of(2020, 12, 4, 0, 0);
        LocalDateTime superCar3ReleaseDate = LocalDateTime.of(2011, 12, 4, 0, 0);

        superCar1.create(SuperCarBrand.ASTON_MARTIN,"WHITE","모닝",3000L,superCar1ReleaseDate);
        superCar2.create(SuperCarBrand.BUGATTI,"WHITE","모닝",3000L,superCar2ReleaseDate);
        superCar3.create(SuperCarBrand.BENTLEY,"WHITE","모닝",3000L,superCar3ReleaseDate);

        log.info("saved superCar: " + superCarRepository.save(superCar1));
        log.info("saved superCar: " + superCarRepository.save(superCar2));
        log.info("saved superCar: " + superCarRepository.save(superCar3));
    }

    @Test
    public void deleteTest() {
        superCarRepository.deleteById(1L);
    }

    @Test
    public void findByIdTest() {
        superCarRepository.findById(2L);
    }

    @Test
    public void findAllTest() {
        superCarRepository.findAll().stream().map(SuperCar::toString).forEach(log::info);
    }

    @Test
    public void getCountOfSuperCarTest() {
        log.info("카운트" + superCarRepository.count());
    }



}
