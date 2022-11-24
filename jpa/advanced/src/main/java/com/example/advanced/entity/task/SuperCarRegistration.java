package com.example.advanced.entity.task;

import javax.persistence.*;

@Entity
@Table(name = "TBL_SUPER_CAR_REGISTRATION")
public class SuperCarRegistration extends Period{
    @Id @GeneratedValue
    private Long carRegistrationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUPER_CAR_ID")
    private SuperCar superCar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUPER_CAR_OWNER_ID")
    private SuperCarOwner superCarOwner;
}
