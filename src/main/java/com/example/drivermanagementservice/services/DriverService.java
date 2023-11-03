package com.example.drivermanagementservice.services;

import com.example.drivermanagementservice.models.Driver;

public interface DriverService {
    Driver registerDriver(String name, String email, String password, String phoneNo, String vehicleModel, String vehicleNumber);
    String getDriverStatus(Long driverId);
    String changeDriverStatus(Long driverId, String status);
    Long assignRide(Long rideId);


}
