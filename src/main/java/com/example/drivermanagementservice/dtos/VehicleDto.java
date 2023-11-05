package com.example.drivermanagementservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDto {
    private Long id;
    private String vehicleModel;
    private String vehicleNumber;
}
