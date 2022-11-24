package com.example.intermediate.repository;

import com.example.intermediate.entity.Desktop;
import com.example.intermediate.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
