package com.example.drivermanagementservice.repositories;

import com.example.drivermanagementservice.models.Driver;
import com.example.drivermanagementservice.models.DriverStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    List<Driver> findAllByStatusEquals(DriverStatus status);
}
