package com.java.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entity.BikeStation;

public interface BikeStationRepository extends JpaRepository<BikeStation, Integer> {
    public List<BikeStation> findByNameStartsWith(String name);

    public Page<BikeStation> findByNameStartsWith(String name, Pageable pageable);

    public boolean existsByName(String name);

    public BikeStation findByName(String name);

}
