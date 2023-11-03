package com.example.drivermanagementservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {
    private String name;
    private String email;
    private String phoneNo;
    private String password;
    private String userType;
}
