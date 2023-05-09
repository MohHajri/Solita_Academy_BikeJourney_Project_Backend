package com.java.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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

}
