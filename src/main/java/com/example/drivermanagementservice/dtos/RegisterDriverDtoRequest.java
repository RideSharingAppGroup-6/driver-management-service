package com.example.drivermanagementservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDriverDtoRequest {
    private String name;
    private String email;
    private String password;
    private String phoneNo;
    private String vehicleModel;
    private String vehicleNumber;

}
