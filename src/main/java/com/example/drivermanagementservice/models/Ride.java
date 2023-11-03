package com.example.drivermanagementservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ride extends BaseModel{
    private String name;
    private String location;
}
