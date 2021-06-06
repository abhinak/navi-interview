package com.example.demo.repository;

import com.example.demo.model.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer> {
}
