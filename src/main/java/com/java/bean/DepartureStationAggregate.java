package com.java.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DepartureStationAggregate {

    private long noOfStartingTrips;
    private double avgDistanceOfStartingTrips;

    public DepartureStationAggregate() {
    }

    public DepartureStationAggregate(long noOfStartingTrips, double avgDistanceOfStartingTrips) {
        super();
        this.noOfStartingTrips = noOfStartingTrips;
        this.avgDistanceOfStartingTrips = avgDistanceOfStartingTrips;
    }

    public long getNoOfStartingTrips() {
        return noOfStartingTrips;
    }

    public void setNoOfStartingTrips(long noOfStartingTrips) {
        this.noOfStartingTrips = noOfStartingTrips;
    }

    public double getAvgDistanceOfStartingTrips() {
        return avgDistanceOfStartingTrips;
    }

    public void setAvgDistanceOfStartingTrips(double avgDistanceOfStartingTrips) {
        this.avgDistanceOfStartingTrips = avgDistanceOfStartingTrips;
    }

    @Override
    public String toString() {
        return "DepartureStationAggregate [noOfStartingTrips=" + noOfStartingTrips + ", avgDistanceOfStartingTrips="
                + avgDistanceOfStartingTrips + "]";
    }

}
