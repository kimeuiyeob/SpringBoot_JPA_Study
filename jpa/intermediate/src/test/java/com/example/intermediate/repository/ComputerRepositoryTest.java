package com.example.intermediate.repository;

import com.example.intermediate.entity.Desktop;
import com.example.intermediate.entity.Phone;
import com.example.intermediate.type.Hardware;
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
public class ComputerRepositoryTest {
    @Autowired
    private DesktopRepository desktopRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Test
    public void saveTest(){
        Desktop desktop = new Desktop();
        Phone phone = new Phone();
        Hardware hardware = new Hardware();

        hardware.create(8, 512, "RTX3050", "Intel");

        phone.create(640, "애플", "프로 14", 2_000_000, LocalDateTime.now(), hardware, 900);
        desktop.create(1980, "삼성", "갤럭시북", 2_000_000, LocalDateTime.now(), hardware, "적축");

        phoneRepository.save(phone);
        desktopRepository.save(desktop);
    }

    @Test
    public void updateTest(){
//        assertThat(desktopRepository.findById(1l).get().getComputerBrand()).isEqualTo("삼성");
//        desktopRepository.findById(2L).get().setComputerBrand("LG");
        phoneRepository.findById(1L).get().setComputerBrand("삼성");
    }
}



















