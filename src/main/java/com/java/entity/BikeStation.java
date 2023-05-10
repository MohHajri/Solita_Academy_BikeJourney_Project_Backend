package com.java.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "bikestationdetails")
public class BikeStation {

    @Id
    @Column(name = "stationid")
    private int id;

    @Column(name = "stationname")
    private String name;

    @Column(name = "stationaddress")
    private String address;

    @Column(name = "stationcity")
    private String city;

    @Column(name = "stationoperator")
    private String operator;

    @Column(name = "stationcapacity")
    private int capacity;

    @Column(name = "xcoordinate")
    private float xCoordinate;

    @Column(name = "ycoordinate")
    private float yCoordinate;

    @JsonIgnore
    @OneToMany(mappedBy = "depatureBikeStation")
    private List<BikeTrip> depatureBikeTrip;

    @JsonIgnore
    @OneToMany(mappedBy = "returnBikeStation")
    private List<BikeTrip> returnBikeTrip;

    public BikeStation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(float xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public float getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(float yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public List<BikeTrip> getDepatureBikeTrip() {
        return depatureBikeTrip;
    }

    public void setDepatureBikeTrip(List<BikeTrip> depatureBikeTrip) {
        this.depatureBikeTrip = depatureBikeTrip;
    }

    public List<BikeTrip> getReturnBikeTrip() {
        return returnBikeTrip;
    }

    public void setReturnBikeTrip(List<BikeTrip> returnBikeTrip) {
        this.returnBikeTrip = returnBikeTrip;
    }

    @Override
    public String toString() {
        return "BikeStation [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", operator="
                + operator + ", capacity=" + capacity + ", xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate
                + ", depatureBikeTrip=" + depatureBikeTrip + ", returnBikeTrip=" + returnBikeTrip + "]";
    }

}
