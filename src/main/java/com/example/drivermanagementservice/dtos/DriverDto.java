package com.example.drivermanagementservice.dtos;

import com.example.drivermanagementservice.models.DriverStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DriverDto {
    private Long userId;
    private VehicleDto vehicle;
    private DriverStatus status;
    private List<Long> rideIds= new ArrayList<>();
}
