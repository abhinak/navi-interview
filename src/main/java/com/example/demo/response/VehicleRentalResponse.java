package com.example.demo.response;

import lombok.Data;

@Data
public class VehicleRentalResponse {

    public VehicleRentalResponse(boolean isSuccess){
        this.isSuccess=isSuccess;
    }

    public VehicleRentalResponse(boolean isSuccess, String errorMessage){
        this.isSuccess=isSuccess;
        this.errorMessage=errorMessage;
    }

    private boolean isSuccess;

    private String errorMessage;
}
