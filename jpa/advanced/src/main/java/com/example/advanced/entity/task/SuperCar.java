package com.example.advanced.entity.task;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TBL_SUPER_CAR")
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SuperCar extends Period{
    @Id @GeneratedValue
    private Long carId;
    private String carBrand;
    private String carName;
    private String carColor;
    private Long carPrice;
    private LocalDateTime carReleaseDate;

    @OneToMany(mappedBy = "superCar", fetch = FetchType.LAZY)
    private List<SuperCarRegistration> superCarRegistrations;
}



















