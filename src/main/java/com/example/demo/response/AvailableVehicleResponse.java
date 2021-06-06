package com.example.demo.response;


import com.example.demo.model.VehicleEntity;
import lombok.Data;

import java.util.List;

@Data
public class AvailableVehicleResponse {

    private boolean isSuccess;

    private List<VehicleEntity> vehicleEntities;

    public AvailableVehicleResponse(boolean isSuccess, List<VehicleEntity> vehicleEntities){
        this.isSuccess=isSuccess;
        this.vehicleEntities=vehicleEntities;
    }

}
