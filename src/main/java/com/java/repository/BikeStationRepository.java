package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.entity.BikeStation;

@Repository
public interface BikeStationRepository extends JpaRepository<BikeStation, Integer> {

    List<BikeStation> findByName(String name);

}
