package com.example.advanced.repository;

import com.example.advanced.entity.Pet;
import com.example.advanced.mapper.TimeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PetMyBatisRepository {
    private final TimeMapper timeMapper;

    public String getTime() {
        return timeMapper.getTime();
    }

    public List<Pet> findByGender(String gender) {
        return timeMapper.select(gender);
    }
}
