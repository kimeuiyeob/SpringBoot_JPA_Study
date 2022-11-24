package com.example.advanced.entity;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Component
@Data
@NoArgsConstructor
public class OwnerDTO {
    private Long ownerId;
    private String ownerName;
    private String ownerPhone;
    private Integer ownerAge;

    @QueryProjection
    public OwnerDTO(Long ownerId, String ownerName, String ownerPhone, Integer ownerAge) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.ownerAge = ownerAge;
    }
}
