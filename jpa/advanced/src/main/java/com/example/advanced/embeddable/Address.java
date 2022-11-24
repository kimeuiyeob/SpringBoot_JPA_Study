package com.example.advanced.embeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
public class Address {
    private String carOwnerZipcode;
    private String carOwnerAddress;
    private String carOwnerAddressDetail;

    public void create(String carOwnerZipcode, String carOwnerAddress, String carOwnerAddressDetail) {
        this.carOwnerZipcode = carOwnerZipcode;
        this.carOwnerAddress = carOwnerAddress;
        this.carOwnerAddressDetail = carOwnerAddressDetail;
    }
}
