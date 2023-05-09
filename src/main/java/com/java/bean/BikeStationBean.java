package com.java.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.repository.BikeStationRepository;

@Component
public class BikeStationBean {

    @Autowired
    private BikeStationRepository bikeStationRepository;

    public BikeStationRepository getBikeStationRepository() {
        return bikeStationRepository;
    }

}
