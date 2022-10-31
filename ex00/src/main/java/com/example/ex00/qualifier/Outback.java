package com.example.ex00.qualifier;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Qualifier("outback") @Primary
@Component
@Getter
@ToString
public class Outback implements Restaurant{
    private int steakPrice = Restaurant.steakPrice + 10000;

    @Override
    public boolean useSaladBar() {
        return false;
    }
}
