package com.example.drivermanagementservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Driver extends BaseModel{
    private Long userId;
    @OneToOne
    private Vehicle vehicle;
    @Enumerated(EnumType.STRING)
    private DriverStatus status;
    @ElementCollection
    private List<Long> rides= new ArrayList<>();
}
