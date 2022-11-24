package com.example.advanced.repository;

import com.example.advanced.entity.Pet;
import com.example.advanced.mapper.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PetCustomRepositoryImpl implements PetCustomRepository {
    @Autowired
    private TimeMapper timeMapper;

    @Override
    public String getTime() {
        return timeMapper.getTime();
    }

    @Override
    public List<Pet> findByGender(String gender) {
        return timeMapper.select(gender);
    }
}
