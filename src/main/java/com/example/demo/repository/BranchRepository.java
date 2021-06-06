package com.example.demo.repository;

import com.example.demo.model.BranchEntity;
import com.example.demo.model.BranchVehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<BranchEntity, Integer> {
}
