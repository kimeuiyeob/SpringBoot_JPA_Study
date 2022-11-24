package com.example.advanced.entity;


import com.example.advanced.type.CarBrand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_CAR")
@Getter @Setter @ToString(exclude = "carOwner")
public class Car extends Period{
    @Id @GeneratedValue
    private Long carId;
    @Enumerated(EnumType.STRING)
    private CarBrand carBrand;
    private String carName;
    private String carColor;
    private Long carPrice;
    private LocalDateTime carReleaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_OWNER_ID")
    private CarOwner carOwner;

    public void create(CarBrand carBrand, String carName, String carColor, Long carPrice, LocalDateTime carReleaseDate) {
        this.carBrand = carBrand;
        this.carName = carName;
        this.carColor = carColor;
        this.carPrice = carPrice;
        this.carReleaseDate = carReleaseDate;
    }

    public void changeCarOwner(CarOwner carOwner){
        this.carOwner = carOwner;
    }
}


















