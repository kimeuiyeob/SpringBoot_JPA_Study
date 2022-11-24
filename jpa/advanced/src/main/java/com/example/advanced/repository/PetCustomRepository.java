package com.example.advanced.repository;

import com.example.advanced.entity.Owner;
import com.example.advanced.entity.Pet;

import java.util.List;

public interface PetCustomRepository {
    public String getTime();
    public List<Pet> findByGender(String gender);
}
