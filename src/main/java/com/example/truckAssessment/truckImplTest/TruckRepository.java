package com.example.truckAssessment.truckImplTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long>{
    Optional<Truck> findByRegNumber(String regNumber);
}
