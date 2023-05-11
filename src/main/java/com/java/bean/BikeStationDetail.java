package com.java.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BikeStationDetail {
    private String stationName;
    private String stationAddress;

    @Autowired
    private DepartureStationAggregate departureStationAggregate;

    @Autowired
    private ReturnStationAggregate returnStationAggregate;

    private List<String> topFiveDepartureStations;
    private List<String> topFiveReturnStations;

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

    public DepartureStationAggregate getDepartureStationAggregate() {
        return departureStationAggregate;
    }

    public void setDepartureStationAggregate(DepartureStationAggregate departureStationAggregate) {
        this.departureStationAggregate = departureStationAggregate;
    }

    public ReturnStationAggregate getReturnStationAggregate() {
        return returnStationAggregate;
    }

    public void setReturnStationAggregate(ReturnStationAggregate returnStationAggregate) {
        this.returnStationAggregate = returnStationAggregate;
    }

    public List<String> getTopFiveDepartureStations() {
        return topFiveDepartureStations;
    }

    public void setTopFiveDepartureStations(List<String> topFiveDepartureStations) {
        this.topFiveDepartureStations = topFiveDepartureStations;
    }

    public List<String> getTopFiveReturnStations() {
        return topFiveReturnStations;
    }

    public void setTopFiveReturnStations(List<String> topFiveReturnStations) {
        this.topFiveReturnStations = topFiveReturnStations;
    }

}
