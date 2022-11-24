package com.example.basic.domain.entity;

import com.example.basic.type.SuperCarBrand;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_SUPER_CAR")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SuperCar {
    @Id @GeneratedValue
    @Column(name = "SUPER_CAR_ID")
    private Long superCarId;
    @Enumerated(EnumType.STRING)
    @Column(name = "SUPER_CAR_BRAND")
    private SuperCarBrand superCarBrand;
    @Column(name = "SUPER_CAR_COLOR")
    private String superCarColor;
    @Column(name = "SUPER_CAR_NAME")
    private String superCarName;
    @Column(name = "SUPER_CAR_PRICE")
    private Long superCarPrice;
    @Column(name = "SUPER_CAR_RELEASE_DATE")
    private LocalDateTime superCarReleaseDate;

    public void create(SuperCarBrand superCarBrand, String superCarColor, String superCarName, Long superCarPrice, LocalDateTime superCarReleaseDate) {
        this.superCarBrand = superCarBrand;
        this.superCarColor = superCarColor;
        this.superCarName = superCarName;
        this.superCarPrice = superCarPrice;
        this.superCarReleaseDate = superCarReleaseDate;
    }
}
