package com.example.intermediate.type;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// 상속관계가 아니다
// 각 필드만 개별적으로 사용되지 않고, 묶어서 한 번에 사용될 때 Embedded방식을 사용한다.
// 만약 Embaddable에 선언된 필드를 통채로 자주 사용할 경우 Embadded방식으로 설계한다.
@Embeddable // 모듈화
public class Hardware {
    @Column(name = "COMPUTER_RAM")
    private int computerRAM;
    @Column(name = "COMPUTER_SSD")
    private int computerSSD;
    @Column(name = "COMPUTER_GPU")
    private String computerGPU;
    private String computerProcessor;

    public void create(int computerRAM, int computerSSD, String computerGPU, String computerProcessor) {
        this.computerRAM = computerRAM;
        this.computerSSD = computerSSD;
        this.computerGPU = computerGPU;
        this.computerProcessor = computerProcessor;
    }
}
