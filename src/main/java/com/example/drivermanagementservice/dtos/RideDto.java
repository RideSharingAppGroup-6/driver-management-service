package com.example.drivermanagementservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RideDto {
    private Double latitiudeSource;
    private Double longitudeSource;
    private Double latitudeDestination;
    private Double longitudeDestination;
    private Long userId;
    private RideStatusDto rideStatus;
    private Integer amount;
}
