package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "branch")
@Data
public class UserVehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "vehicleId")
    private VehicleEntity vehicleEntity;

    private Integer bookigTime;

    private Integer droppingTime;

    @CreationTimestamp
    private Timestamp createdTimestamp;

    @UpdateTimestamp
    private Timestamp modifiedTimestamp;

    public UserVehicleEntity (UserEntity userEntity, VehicleEntity vehicleEntity, Integer bookigTime, Integer droppingTime){
        this.userEntity=userEntity;
        this.vehicleEntity=vehicleEntity;
        this.bookigTime=bookigTime;
        this.droppingTime=droppingTime;
    }

}
