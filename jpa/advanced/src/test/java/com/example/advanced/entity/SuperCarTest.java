package com.example.advanced.entity;

import com.example.advanced.embeddable.Address;
import com.example.advanced.repository.CarOwnerRepository;
import com.example.advanced.repository.CarRepository;
import com.example.advanced.type.CarBrand;
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
public class SuperCarTest {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarOwnerRepository carOwnerRepository;

    @Test
    public void saveTest(){
        CarOwner carOwner = new CarOwner();
        Address address = new Address();
        Car car = new Car();

        address.create("12345", "남양주시 화도읍", "휘게타운하우스");
        carOwner.create("한동석", 20, address);

        car.create(CarBrand.KIA, "오피러스", "흰색", 9_000_000L, LocalDateTime.of(2003, 12, 4, 0, 0));
        car.changeCarOwner(carOwner);

        carOwnerRepository.save(carOwner);
        carRepository.save(car);
    }

    @Test
    public void findByAddress(){
        assertThat(carOwnerRepository.findByAddress_CarOwnerZipcode("12345").get(0).getAddress().getCarOwnerZipcode()).isEqualTo("12345");
        assertThat(carOwnerRepository.findByCarOwnerZipcode("12345").get(0).getAddress().getCarOwnerZipcode()).isEqualTo("12345");
    }

    @Test
    public void delete(){
        carOwnerRepository.delete(carOwnerRepository.findById(1L).get());
//        carRepository.delete(carRepository.findById(2L).get());
    }
}


























