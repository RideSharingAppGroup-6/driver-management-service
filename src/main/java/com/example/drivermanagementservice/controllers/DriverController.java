package com.example.drivermanagementservice.controllers;

import com.example.drivermanagementservice.dtos.AssignRideResponse;
import com.example.drivermanagementservice.dtos.RegisterDriverDtoRequest;
import com.example.drivermanagementservice.dtos.RegisterDriverResponse;
import com.example.drivermanagementservice.models.Driver;
import com.example.drivermanagementservice.services.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    private DriverService driverService;
    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }
    @PostMapping
    public ResponseEntity<RegisterDriverResponse> registerDriver(@RequestBody RegisterDriverDtoRequest requestDto){
        Driver driver = driverService.registerDriver(requestDto.getName(),
                        requestDto.getEmail(),
                        requestDto.getPassword(),
                        requestDto.getPhoneNo(),
                        requestDto.getVehicleModel(),
                        requestDto.getVehicleNumber());
        RegisterDriverResponse response = new RegisterDriverResponse();
        response.setDriverId(driver.getId());
        response.setMessage("Driver registered successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/{id}/status")
    public ResponseEntity<String> getDriverStatus(@PathVariable("id") Long id){
        String string = driverService.getDriverStatus(id);
        return new ResponseEntity<>(string, HttpStatus.OK);
    }
    @PutMapping("/{id}/status")
    public ResponseEntity<String> changeDriverStatus(@PathVariable("id") Long id, @RequestBody String status){
        String message = driverService.changeDriverStatus(id, status);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @PutMapping("/assign-ride/{rideId}")
    public ResponseEntity<AssignRideResponse> assignRide(@PathVariable Long rideId){
        Long driverId= driverService.assignRide(rideId);
        AssignRideResponse response = new AssignRideResponse();
        response.setDriverId(driverId);
        response.setRideId(rideId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{driver_id}/earnings")
    public ResponseEntity<String> getDriverEarnings(@PathVariable("driver_id") Long driverId){
        return null;
    }
}
