package com.example.drivermanagementservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vehicle extends BaseModel{
    private String vehicleModel;
    private String vehicleNumber;
}
