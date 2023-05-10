package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entity.BikeStation;

public interface BikeStationRepository extends JpaRepository<BikeStation, Integer> {

    List<BikeStation> findByName(String name);

}
