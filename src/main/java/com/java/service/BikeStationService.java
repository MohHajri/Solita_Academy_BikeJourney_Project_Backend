package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.entity.BikeStation;
import com.java.repository.BikeStationRepository;

@Service
public class BikeStationService {

    @Autowired
    private BikeStationRepository bikeStationRepository;

    public BikeStation getBikeStationById(int id) {
        return bikeStationRepository.findById(id).orElse(null);
    }

    public List<BikeStation> getAllBikeStations() {
        return bikeStationRepository.findAll();
    }

    public List<BikeStation> getBikeStationsByName(String name) {
        return bikeStationRepository.findByName(name);
    }

    public BikeStation saveBikeStation(BikeStation bikeStation) {
        return bikeStationRepository.save(bikeStation);
    }

}
