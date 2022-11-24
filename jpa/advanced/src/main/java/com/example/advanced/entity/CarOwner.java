package com.example.advanced.entity;

import com.example.advanced.embeddable.Address;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_CAR_OWNER")
@Getter @Setter @ToString
public class CarOwner extends Period{
    @Id @GeneratedValue
    private Long carOwnerId;
    private String carOwnerName;
    private int carOwnerAge;
    @Embedded
    private Address address;

    public void create(String carOwnerName, int carOwnerAge, Address address) {
        this.carOwnerName = carOwnerName;
        this.carOwnerAge = carOwnerAge;
        this.address = address;
    }
}
