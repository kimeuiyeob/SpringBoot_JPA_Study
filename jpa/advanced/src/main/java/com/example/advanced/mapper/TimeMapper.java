package com.example.advanced.mapper;

import com.example.advanced.entity.Pet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TimeMapper {
    public String getTime();
    public List<Pet> select(String gender);
}
