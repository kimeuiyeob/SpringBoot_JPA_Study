package com.example.intermediate.repository;

import com.example.intermediate.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    public List<Developer> findByDeveloperLevel(@Param("developerLevel") int level);
}
