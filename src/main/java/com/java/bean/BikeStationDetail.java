package com.java.bean;

import org.springframework.stereotype.Component;

@Component
public class BikeStationDetail {

    private String stationName;
    private String stationAddress;

    public BikeStationDetail() {

    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

}
