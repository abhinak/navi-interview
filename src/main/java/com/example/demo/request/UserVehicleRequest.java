package com.example.demo.request;

import com.example.demo.model.BranchEntity;
import com.example.demo.model.UserEntity;
import com.example.demo.model.VehicleEntity;
import lombok.Data;

@Data
public class UserVehicleRequest {

    private UserEntity userEntity;

    private VehicleEntity vehicleEntity;

    private BranchEntity branchEntity;

    private Integer bookingTime;
}
