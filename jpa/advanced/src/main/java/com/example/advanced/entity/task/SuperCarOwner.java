package com.example.advanced.entity.task;

import com.example.advanced.embeddable.Address;
import com.example.advanced.entity.Period;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_SUPER_CAR_OWNER")
@Getter @Setter @ToString
public class SuperCarOwner extends Period {
    @Id
    @GeneratedValue
    private Long carOwnerId;
    private String carOwnerName;
    private int carOwnerAge;
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "superCarOwner", fetch = FetchType.LAZY)
    private List<SuperCarRegistration> superCarRegistrations;
}
















