/*
* 컴퓨터(Computer)
   해상도(Screen)
   브랜드(Brand)
   상품명(Name)
   가격(Price)
   출시일(ReleaseDate)
   램(Ram)
   SSD
   GPU
   Processor
   등록일(CreatedDate)
   수정일(UpdatedDate)

데스크탑(Desktop)
   키보드타입(Keyboard)

핸드폰(Phone)
   배터리용량(Battery)
*
* */
package com.example.intermediate.entity;

import com.example.intermediate.type.Hardware;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ELECTRONIC_DEVICE")
@Table(name = "TBL_COMPUTER")
@Getter @Setter @ToString
@NoArgsConstructor /*Period클래스를 만들어 (createdDate, updatedDate)를 상속받아서 사용한다. */
public class Computer extends Period{

    @Id @GeneratedValue
    private Long computerId;
    private int computerScreen;
    private String computerBrand;
    private String computerName;
    private int computerPrice;
    private LocalDateTime computerReleaseDate;

    /*RAM,SSD,CPU등등은 하드웨어 클래스를 만들어서 한객체로 묶어줬다.*/
    @Embedded // 하드웨어클래스에 @Embeddable이걸로 선언해주고 @Embedded이걸로 사용해준다.
    private Hardware hardware; /* <= RAM,SSD,GPU,Process가 있다.*/

    public void create(int computerScreen, String computerBrand, String computerName, int computerPrice, LocalDateTime computerReleaseDate, Hardware hardware) {
        this.computerScreen = computerScreen;
        this.computerBrand = computerBrand;
        this.computerName = computerName;
        this.computerPrice = computerPrice;
        this.computerReleaseDate = computerReleaseDate;
        this.hardware = hardware; /*하드웨어를 이렇게 받아주면 깔끔하다.*/
    }
}





















