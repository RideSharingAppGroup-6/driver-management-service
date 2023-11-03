package com.example.drivermanagementservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class ErrorDetails {
    private String message;
    private Date timestamp;
    private String path;
}
