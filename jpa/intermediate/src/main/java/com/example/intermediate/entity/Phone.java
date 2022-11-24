package com.example.intermediate.entity;

import com.example.intermediate.type.Hardware;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("Phone")
@Table(name = "TBL_PHONE")
@Getter @Setter @ToString
@NoArgsConstructor
public class Phone extends Computer{
    private int phoneBattery;

    public void create(int computerScreen, String computerBrand, String computerName, int computerPrice, LocalDateTime computerReleaseDate, Hardware hardware, int phoneBattery) {
        super.create(computerScreen, computerBrand, computerName, computerPrice, computerReleaseDate, hardware);
        this.phoneBattery = phoneBattery;
    }
}
