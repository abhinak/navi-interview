package com.example.demo.controller;

import com.example.demo.enums.VehicleStatus;
import com.example.demo.model.*;
import com.example.demo.request.UserVehicleRequest;
import com.example.demo.request.VehicleAdditionRequest;
import com.example.demo.response.AvailableVehicleResponse;
import com.example.demo.response.VehicleRentalResponse;
import com.example.demo.service.BranchService;
import com.example.demo.service.BranchVehicleService;
import com.example.demo.service.UserVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RequestMapping("/v1")
@RestController
public class BranchController {

    @Autowired
    BranchVehicleService branchVehicleService;

    @Autowired
    BranchService branchService;

    @Autowired
    UserVehicleService userVehicleService;

    @PostMapping(value = "/vehicles")
    public ResponseEntity<VehicleRentalResponse> addBranch(@RequestBody VehicleAdditionRequest vehicleAdditionRequest){

        Integer branchId = vehicleAdditionRequest.getBranchId();
        BranchEntity branchEntity = branchService.getBranch(branchId);
        VehicleRentalResponse vehicleRentalResponse;

        List<VehicleEntity> vehicles = vehicleAdditionRequest.getVehicles();
        try {

            for (VehicleEntity vehicleEntity : vehicles) {

                branchVehicleService.addBranch(new BranchVehicleEntity(branchEntity, vehicleEntity, VehicleStatus.AVAILABLE));
            }
        }
        catch (Exception e){
            vehicleRentalResponse = new VehicleRentalResponse(false,e.getMessage());
            return new ResponseEntity<>(vehicleRentalResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        vehicleRentalResponse = new VehicleRentalResponse(true);
        return new ResponseEntity<>(vehicleRentalResponse,HttpStatus.OK);

    }

    @GetMapping(value = "/vehicles/{branchId}")
    public ResponseEntity<AvailableVehicleResponse> showSlots(@PathVariable Integer branchId){
            BranchEntity branchEntity = branchService.getBranch(branchId);

            AvailableVehicleResponse availableVehicleResponse;

            List<VehicleEntity> availableVehicles = branchVehicleService.getAvailableVehicles(branchId);

        Collections.sort(availableVehicles,new Comparator<VehicleEntity>() {
            @Override
            public int compare(VehicleEntity v1, VehicleEntity v2) {
                return v1.getPrice().compareTo(v2.getPrice());
            }
        });

        availableVehicleResponse = new AvailableVehicleResponse(true,availableVehicles);
        return new ResponseEntity<>(availableVehicleResponse,HttpStatus.OK);

    }

    @PostMapping(value = "/vehicles/user")
    public ResponseEntity<VehicleRentalResponse> bookABike(@RequestBody UserVehicleRequest userVehicleRequest){
        UserEntity userEntity = userVehicleRequest.getUserEntity();
        VehicleEntity vehicleEntity = userVehicleRequest.getVehicleEntity();
        BranchEntity branchEntity = userVehicleRequest.getBranchEntity();

        Integer bookingTime = userVehicleRequest.getBookingTime();

        VehicleRentalResponse vehicleRentalResponse;

        try {

            BranchVehicleEntity branchVehicleEntity = branchVehicleService.findByBranchEntityAndVehicleEntity(branchEntity, vehicleEntity);
            branchVehicleEntity.setVehicleStatus(VehicleStatus.BOOKED);
            branchVehicleService.addBranch(branchVehicleEntity);

            UserVehicleEntity userVehicleEntity = new UserVehicleEntity(userEntity, vehicleEntity, bookingTime, bookingTime + 1);

            userVehicleService.addUserVehicle(userVehicleEntity);
        }

        catch (Exception e){
            vehicleRentalResponse=new VehicleRentalResponse(false,e.getMessage());
            return new ResponseEntity<>(vehicleRentalResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        vehicleRentalResponse = new VehicleRentalResponse(true);

        return new ResponseEntity<>(vehicleRentalResponse,HttpStatus.OK);


    }

}
