package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.entity.BikeTrip;

public interface BikeTripRepository extends JpaRepository<BikeTrip, Integer> {

}
