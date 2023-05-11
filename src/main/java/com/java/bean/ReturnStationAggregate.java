package com.java.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ReturnStationAggregate {
    private long noOfEndingTrips;
    private double avgDistanceOfEndingTrips;

    public ReturnStationAggregate() {
    }

    public ReturnStationAggregate(long noOfEndingTrips, double avgDistanceOfEndingTrips) {
        this.noOfEndingTrips = noOfEndingTrips;
        this.avgDistanceOfEndingTrips = avgDistanceOfEndingTrips;
    }

    public long getNoOfEndingTrips() {
        return noOfEndingTrips;
    }

    public void setNoOfEndingTrips(long noOfEndingTrips) {
        this.noOfEndingTrips = noOfEndingTrips;
    }

    public double getAvgDistanceOfEndingTrips() {
        return avgDistanceOfEndingTrips;
    }

    public void setAvgDistanceOfEndingTrips(double avgDistanceOfEndingTrips) {
        this.avgDistanceOfEndingTrips = avgDistanceOfEndingTrips;
    }

    @Override
    public String toString() {
        return "ReturnStationAggregate [noOfEndingTrips=" + noOfEndingTrips + ", avgDistanceOfEndingTrips="
                + avgDistanceOfEndingTrips + "]";
    }

}
