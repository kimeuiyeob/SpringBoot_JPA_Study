package com.example.intermediate.repository;

import com.example.intermediate.entity.Developer;
import com.example.intermediate.entity.Planner;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class EmployeeRepositoryTest {
    @Autowired private DeveloperRepository developerRepository;
    @Autowired private PlannerRepository plannerRepository;

    @Test
    public void saveTest(){
        Developer developer = new Developer();
        Planner planner = new Planner();

        developer.create("한동석", LocalDateTime.now(), 3, 4, 2);
        planner.create("이순신", LocalDateTime.now(), 8, 2, 10);

        assertThat(developerRepository.save(developer).getEmployeeName()).isEqualTo("한동석");
        assertThat(plannerRepository.save(planner).getEmployeeName()).isEqualTo("이순신");

    }

    @Test
    public void findTest(){
        assertThat(developerRepository.findByDeveloperLevel(4).get(0).getEmployeeName()).isEqualTo("한동석");
    }

}





















