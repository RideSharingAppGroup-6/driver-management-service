package com.example.drivermanagementservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {
    @GetMapping("/check")
    public ResponseEntity<String> checkHealth(){
        try {
            return new ResponseEntity<>("Driver Management Service is up and running", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Driver Management Service is down", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
