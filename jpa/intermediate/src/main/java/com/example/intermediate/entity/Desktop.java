package com.example.intermediate.entity;

import com.example.intermediate.type.Hardware;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("Desktop")
@Table(name = "TBL_DESKTOP")
@Getter @Setter @ToString
@NoArgsConstructor
public class Desktop extends Computer{
    private String deskTopKeyboardType;

    public void create(int computerScreen, String computerBrand, String computerName, int computerPrice, LocalDateTime computerReleaseDate, Hardware hardware, String deskTopKeyboardType) {
        super.create(computerScreen, computerBrand, computerName, computerPrice, computerReleaseDate, hardware);
        this.deskTopKeyboardType = deskTopKeyboardType;
    }
}
























