package com.example.intermediate.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("Planner")
@Table(name = "TBL_PLANNER")
@Getter @Setter @ToString
@NoArgsConstructor
public class Planner extends Employee{
    @Column(name = "PLANNER_LEVEL")
    private int plannerLevel;
    @Column(name = "PLANNER_CLIENT_COUNT")
    private int plannerClientCount;

    public void create(String employeeName, LocalDateTime employeeBirth, int employeeCareer, int plannerLevel, int plannerClientCount) {
        super.create(employeeName, employeeBirth, employeeCareer);
        this.plannerLevel = plannerLevel;
        this.plannerClientCount = plannerClientCount;
    }
}
