package com.example.advanced.repository;

import com.example.advanced.entity.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarOwnerRepository extends JpaRepository<CarOwner, Long> {
    public List<CarOwner> findByAddress_CarOwnerZipcode(@Param("carOwnerZipcode") String carOwnerZipcode);

    @Query("select c from SuperCarOwner c where c.address.carOwnerZipcode = :carOwnerZipcode")
    public List<CarOwner> findByCarOwnerZipcode(@Param("carOwnerZipcode") String carOwnerZipcode);
}
