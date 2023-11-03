package com.example.drivermanagementservice.exceptions;

public class DriverNotAvailableException extends RuntimeException{
    public DriverNotAvailableException(String message) {
        super(message);
    }
}
