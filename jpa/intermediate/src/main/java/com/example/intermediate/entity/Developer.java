package com.example.intermediate.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("Developer")
@Table(name = "TBL_DEVELOPER")
@Getter @Setter @ToString
@NoArgsConstructor
public class Developer extends Employee{
    @Column(name = "DEVELOPER_LEVEL")
    private int developerLevel;
    @Column(name = "DEVELOPER_PROJECT_COUNT")
    private int developerProjectCount;

    public void create(String employeeName, LocalDateTime employeeBirth, int employeeCareer, int developerLevel, int developerProjectCount) {
        super.create(employeeName, employeeBirth, employeeCareer);
        this.developerLevel = developerLevel;
        this.developerProjectCount = developerProjectCount;
    }
}














