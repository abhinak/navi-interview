package com.example.demo.repository;

import com.example.demo.enums.VehicleStatus;
import com.example.demo.model.BranchEntity;
import com.example.demo.model.BranchVehicleEntity;
import com.example.demo.model.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchVehicleRepository extends JpaRepository<BranchVehicleEntity, Integer> {

    List<VehicleEntity> findByBranchEntityAndVehicleStatus(Integer id, VehicleStatus vehicleStatus);

    BranchVehicleEntity findByBranchEntityAndVehicleEntity(BranchEntity branchEntity, VehicleEntity vehicleEntity);
}
