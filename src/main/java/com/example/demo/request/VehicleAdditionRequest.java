package com.example.demo.request;

import com.example.demo.enums.VehicleType;
import com.example.demo.model.VehicleEntity;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class VehicleAdditionRequest {

    private Integer branchId;

    private List<VehicleEntity> vehicles;
}
