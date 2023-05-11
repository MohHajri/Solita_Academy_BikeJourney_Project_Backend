package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.java.entity.BikeTrip;
import com.java.repository.BikeTripRepository;

@Service
public class BikeTripService {

    @Autowired
    private BikeTripRepository bikeTripRepository;

    public BikeTrip getBikeTripById(int id) {
        try {
            return bikeTripRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    public Long getCountOfTrips() {
        return bikeTripRepository.count();
    }

}
