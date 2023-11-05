package com.example.drivermanagementservice.services;

import com.example.drivermanagementservice.dtos.EarningsDto;
import com.example.drivermanagementservice.models.Driver;

import java.util.List;

public interface DriverService {
    List<Driver> getAllDrivers();
    Driver registerDriver(String name, String email, String password, String phoneNo, String vehicleModel, String vehicleNumber);
    String getDriverStatus(Long driverId);
    String changeDriverStatus(Long driverId, String status);
    Long assignRide(Long rideId);
    List<EarningsDto> getDriverEarnings(Long driverId);
}
