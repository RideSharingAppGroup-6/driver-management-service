package com.example.drivermanagementservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDriverResponse {
    private String message;
    private Long driverId;
}
