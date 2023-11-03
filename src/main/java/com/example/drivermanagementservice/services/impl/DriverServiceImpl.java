package com.example.drivermanagementservice.services.impl;

import com.example.drivermanagementservice.constants.UrlConstants;
import com.example.drivermanagementservice.dtos.RegisterUserDto;
import com.example.drivermanagementservice.exceptions.DriverNotAvailableException;
import com.example.drivermanagementservice.exceptions.ResourceNotFoundException;
import com.example.drivermanagementservice.models.Driver;
import com.example.drivermanagementservice.models.DriverStatus;
import com.example.drivermanagementservice.models.Vehicle;
import com.example.drivermanagementservice.repositories.DriverRepository;
import com.example.drivermanagementservice.repositories.VehicleRepository;
import com.example.drivermanagementservice.services.DriverService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Service
public class DriverServiceImpl implements DriverService {
    private DriverRepository driverRepository;
    private VehicleRepository vehicleRepository;
    private RestTemplateBuilder restTemplateBuilder;
    public DriverServiceImpl(DriverRepository driverRepository,
                             VehicleRepository vehicleRepository,
                             RestTemplateBuilder restTemplateBuilder){
        this.driverRepository = driverRepository;
        this.vehicleRepository = vehicleRepository;
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public Driver registerDriver(String name, String email, String password, String phoneNo, String vehicleModel, String vehicleNumber) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setName(name);
        registerUserDto.setEmail(email);
        registerUserDto.setPassword(password);
        registerUserDto.setPhoneNo(phoneNo);
        ResponseEntity<Long> response = restTemplate.postForEntity(UrlConstants.REGISTER_USER_URL, new HttpEntity<>(registerUserDto), Long.class);
        Long userId = response.getBody();
        Driver driver = new Driver();
        driver.setUserId(userId);
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleModel(vehicleModel);
        vehicle.setVehicleNumber(vehicleNumber);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        driver.setVehicle(savedVehicle);
        driver.setStatus(DriverStatus.AVAILABLE);
        return driverRepository.save(driver);
    }

    @Override
    public String getDriverStatus(Long driverId) {
        Driver driver = driverRepository.findById(driverId).orElseThrow(() ->new ResourceNotFoundException("Driver not found"));
        return driver.getStatus().toString();
    }

    @Override
    public String changeDriverStatus(Long driverId, String status) {
        Driver driver = driverRepository.findById(driverId).orElseThrow(() ->new ResourceNotFoundException("Driver not found"));
        driver.setStatus(DriverStatus.valueOf(status));
        return "Driver status is changed to "+status;
    }

    @Override
    public Long assignRide(Long rideId) {
        List<Driver> drivers = driverRepository.findAllByStatusEquals(DriverStatus.AVAILABLE);
        if(drivers.isEmpty()){
            throw new DriverNotAvailableException("No drivers available");
        }
        Random random = new Random();
        int driverIndex = random.nextInt(drivers.size());
        Driver driver = drivers.get(driverIndex);
        driver.getRides().add(rideId);
        return driverRepository.save(driver).getId();
    }
}
