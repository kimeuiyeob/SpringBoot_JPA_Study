package com.example.intermediate.repository;

import com.example.intermediate.entity.Desktop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesktopRepository extends JpaRepository<Desktop, Long> {
}
