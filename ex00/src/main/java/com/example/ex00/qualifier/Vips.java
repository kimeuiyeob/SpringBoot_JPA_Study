package com.example.ex00.qualifier;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("vips")
@Component
@Getter
@ToString
public class Vips implements Restaurant{
    private int steakPrice = Restaurant.steakPrice - 10000;

    @Override
    public boolean useSaladBar() {
        return true;
    }
}
