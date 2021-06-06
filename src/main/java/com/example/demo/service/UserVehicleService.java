package com.example.demo.service;

import com.example.demo.model.UserVehicleEntity;
import com.example.demo.repository.UserVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVehicleService {

    @Autowired
    UserVehicleRepository userVehicleRepository;

    public void addUserVehicle(UserVehicleEntity userVehicleEntity){
        userVehicleRepository.save(userVehicleEntity);
    }
}
