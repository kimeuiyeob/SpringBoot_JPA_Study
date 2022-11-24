package com.example.intermediate.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity // 상속관계에서는 Entity를 사용해야 조회 시 조인이 가능하다.
@DiscriminatorColumn(name = "EMPLOYEE_DEPARTMENT")
@Table(name = "TBL_EMPLOYEE")
@Getter @Setter @ToString
@NoArgsConstructor
public abstract class Employee { // 만약 상속관계에서 부모 클래스를 직접 사용할 일이 없으면 abstract 키워드를 붙여준다.
    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;
    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;
    @Column(name = "EMPLOYEE_BIRTH")
    private LocalDateTime employeeBirth;
    @Column(name = "EMPLOYEE_CAREER")
    private int employeeCareer;

    public void create(String employeeName, LocalDateTime employeeBirth, int employeeCareer) {
        this.employeeName = employeeName;
        this.employeeBirth = employeeBirth;
        this.employeeCareer = employeeCareer;
    }
}
