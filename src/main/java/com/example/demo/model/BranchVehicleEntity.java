package com.example.demo.model;

import com.example.demo.enums.VehicleStatus;
import com.example.demo.enums.VehicleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "branch")
@Data
public class BranchVehicleEntity {

    public BranchVehicleEntity(BranchEntity branchEntity, VehicleEntity vehicleEntity, VehicleStatus vehicleStatus){
        this.branchEntity=branchEntity;
        this.vehicleEntity=vehicleEntity;
        this.vehicleStatus = vehicleStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "vehicleId")
    private VehicleEntity vehicleEntity;

    @ManyToOne
    @JoinColumn(name = "branchId")
    private BranchEntity branchEntity ;

    private VehicleStatus vehicleStatus;


    @CreationTimestamp
    private Timestamp createdTimestamp;

    @UpdateTimestamp
    private Timestamp modifiedTimestamp;

}
