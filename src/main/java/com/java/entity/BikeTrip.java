package com.java.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "biketrips")
public class BikeTrip {

    @Id
    @Column(name = "tripid", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "departuretime")
    private Timestamp departureTime;

    @Column(name = "returntime")
    private Timestamp returnTime;

    @Column(name = "departurestationid")
    private int departureStationId;

    @Column(name = "departurestationname")
    private String departureStationName;

    @Column(name = "returnstationid")
    private int returnStationId;

    @Column(name = "returnstationname")
    private String returnStationName;

    @Column(name = "covereddistanceinmeter")
    private float coveredDistanceInMeter;

    @Column(name = "durationinsec")
    private float durationInSec;

    @ManyToOne
    @JoinColumn(name = "departurestationid", referencedColumnName = "stationid", insertable = false, updatable = false)
    private BikeStation depatureBikeStation;

    @ManyToOne
    @JoinColumn(name = "returnstationid", referencedColumnName = "stationid", insertable = false, updatable = false)
    private BikeStation returnBikeStation;

    public BikeTrip() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public int getDepartureStationId() {
        return departureStationId;
    }

    public void setDepartureStationId(int departureStationId) {
        this.departureStationId = departureStationId;
    }

    public String getDepartureStationName() {
        return departureStationName;
    }

    public void setDepartureStationName(String departureStationName) {
        this.departureStationName = departureStationName;
    }

    public int getReturnStationId() {
        return returnStationId;
    }

    public void setReturnStationId(int returnStationId) {
        this.returnStationId = returnStationId;
    }

    public String getReturnStationName() {
        return returnStationName;
    }

    public void setReturnStationName(String returnStationName) {
        this.returnStationName = returnStationName;
    }

    public float getCoveredDistanceInMeter() {
        return coveredDistanceInMeter;
    }

    public void setCoveredDistanceInMeter(float coveredDistanceInMeter) {
        this.coveredDistanceInMeter = coveredDistanceInMeter;
    }

    public float getDurationInSec() {
        return durationInSec;
    }

    public void setDurationInSec(float durationInSec) {
        this.durationInSec = durationInSec;
    }

    public BikeStation getDepatureBikeStation() {
        return depatureBikeStation;
    }

    public void setDepatureBikeStation(BikeStation depatureBikeStation) {
        this.depatureBikeStation = depatureBikeStation;
    }

    public BikeStation getReturnBikeStation() {
        return returnBikeStation;
    }

    public void setReturnBikeStation(BikeStation returnBikeStation) {
        this.returnBikeStation = returnBikeStation;
    }

    @Override
    public String toString() {
        return "BikeTrip [id=" + id + ", departureTime=" + departureTime + ", returnTime=" + returnTime
                + ", departureStationId=" + departureStationId + ", departureStationName=" + departureStationName
                + ", returnStationId=" + returnStationId + ", returnStationName=" + returnStationName
                + ", coveredDistanceInMeter=" + coveredDistanceInMeter + ", durationInSec=" + durationInSec
                + ", depatureBikeStation=" + depatureBikeStation + ", returnBikeStation=" + returnBikeStation + "]";
    }

}
