package com.example.demo.service;

import com.example.demo.enums.VehicleStatus;
import com.example.demo.model.BranchEntity;
import com.example.demo.model.BranchVehicleEntity;
import com.example.demo.model.VehicleEntity;
import com.example.demo.repository.BranchVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchVehicleService {

    @Autowired
    BranchVehicleRepository branchVehicleRepository;

    public void addBranch(BranchVehicleEntity branchEntity){
        branchVehicleRepository.save(branchEntity);
    }

    public List<VehicleEntity> getAvailableVehicles(Integer brachId){
        return  branchVehicleRepository.findByBranchEntityAndVehicleStatus(brachId, VehicleStatus.AVAILABLE);
    }

    public BranchVehicleEntity findByBranchEntityAndVehicleEntity(BranchEntity branchEntity, VehicleEntity vehicleEntity){
        return branchVehicleRepository.findByBranchEntityAndVehicleEntity(branchEntity,vehicleEntity);
    }
}
