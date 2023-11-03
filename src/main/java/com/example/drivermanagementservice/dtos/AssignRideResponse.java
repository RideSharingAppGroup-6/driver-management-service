package com.example.drivermanagementservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignRideResponse {
    private Long rideId;
    private Long driverId;
}
