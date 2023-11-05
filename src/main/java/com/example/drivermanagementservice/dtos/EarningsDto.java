package com.example.drivermanagementservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EarningsDto {
    private Long rideId;
    private int amount;
}
