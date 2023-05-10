package com.java.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java.bean.BikeStationDetail;
import com.java.entity.BikeStation;
import com.java.repository.BikeStationRepository;

@Service
public class BikeStationService {

    @Autowired
    private BikeStationRepository bikeStationRepository;

    public List<BikeStation> getAllBikeStations() {

        try {
            return bikeStationRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving bike stations", e);
        }
    }

    /*
     * This method is used to get the bike stations by page
     */

    public BikeStation getBikeStationById(int bikeStationId) {
        try {
            return bikeStationRepository.findById(bikeStationId).get();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * This method is used to get the bike stations by name
     * 
     */

    public HashMap<String, Object> getBikeStationsByName(String name, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<BikeStation> bikeStationPage = bikeStationRepository.findByNameStartsWith(name, pageable);

        HashMap<String, Object> tempMap = new HashMap<String, Object>();
        tempMap.put("pageContent", bikeStationPage.getContent());
        tempMap.put("totalPages", bikeStationPage.getTotalPages());
        return tempMap;
    }

    /**
     * This method is used to get the bike station details by station name
     */
    public BikeStationDetail getBikeStationDetails(String stationName) {

        if (bikeStationRepository.existsByName(stationName)) {

            BikeStationDetail bikeStationDetails = new BikeStationDetail();
            bikeStationDetails.setStationName(stationName);
            bikeStationDetails.setStationAddress(bikeStationRepository.findByName(stationName).getAddress());
            return bikeStationDetails;
        } else {
            return null;
        }

    }

    public BikeStation saveBikeStation(BikeStation bikeStation) {
        return bikeStationRepository.save(bikeStation);
    }

}
