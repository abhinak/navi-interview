package com.example.demo.repository;

import com.example.demo.model.UserVehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVehicleRepository extends JpaRepository<UserVehicleEntity, Integer> {
}
