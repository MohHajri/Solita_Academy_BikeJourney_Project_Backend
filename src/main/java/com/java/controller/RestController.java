package com.java.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.bean.BikeStationDetail;
import com.java.entity.BikeStation;
import com.java.entity.BikeTrip;
import com.java.service.BikeStationService;
import com.java.service.BikeTripService;

@CrossOrigin(origins = "${cors.allowed.origins}")
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private BikeTripService bikeTripService;

    @Autowired
    private BikeStationService bikeStationService;

    @GetMapping("/getalltrips")
    public HashMap<String, Object> getAllBikeTrips(@RequestParam("pagenumber") int pageNumber,
            @RequestParam("numberoftrips") int numberOfTrips, @RequestParam("sortingcolumn") String sortingColumn,
            @RequestParam("isascending") boolean isAscending) {

        return bikeTripService.getAllBikeTrips(pageNumber, numberOfTrips, sortingColumn, isAscending);
    }

    @GetMapping("/gettripbyid")
    public BikeTrip getBikeTripById(@RequestParam("id") int id) {
        return bikeTripService.getBikeTripById(id);
    }

    @GetMapping("/getcountoftrips")
    public Long getCountOfTrips() {
        return bikeTripService.getCountOfTrips();
    }

    @GetMapping("/getallstations")
    public List<BikeStation> getAllBikeStations() {
        return bikeStationService.getAllBikeStations();
    }

    @GetMapping("/getstationbyid")
    public BikeStation getBikeStationById(@RequestParam("stationid") int stationid) {
        return bikeStationService.getBikeStationById(stationid);
    }

    @GetMapping("/getstationsbyname")
    public HashMap<String, Object> getStationsByName(@RequestParam("stationname") String stationName,
            @RequestParam("pagenumber") int page, @RequestParam("numberofstations") int size) {
        return bikeStationService.getBikeStationsByName(stationName, page, size);
    }

    @GetMapping("/getstationdetailsbyname")
    public BikeStationDetail getBikeStationDetailsByName(@RequestParam("stationname") String stationName) {
        return bikeStationService.getBikeStationDetails(stationName);
    }

    @GetMapping("/getstationdetailsbynamewithdatefilter")
    public BikeStationDetail getBikeStationDetailsByNameWithDateFilter(@RequestParam("stationname") String stationName,
            @RequestParam("startdate") Timestamp startDate, @RequestParam("enddate") Timestamp endDate) {
        return bikeStationService.getBikeStationDetailsWithDateFilter(stationName, startDate, endDate);
    }

    @PostMapping("/savebiketrip")
    public ResponseEntity<BikeTrip> saveBikeTrip(@RequestParam("departureTime") Timestamp departureTime,
            @RequestParam("returnTime") Timestamp returnTime,
            @RequestParam("departureStationId") int departureStationId,
            @RequestParam("departureStationName") String departureStationName,
            @RequestParam("returnStationId") int returnStationId,
            @RequestParam("returnStationName") String returnStationName,
            @RequestParam("coveredDistanceInMeter") float coveredDistanceInMeter,
            @RequestParam("durationInSec") float durationInSec) {

        BikeTrip bikeTrip = new BikeTrip();

        bikeTrip.setDepartureTime(departureTime);
        bikeTrip.setReturnTime(returnTime);
        bikeTrip.setDepartureStationId(departureStationId);
        bikeTrip.setDepartureStationName(departureStationName);
        bikeTrip.setReturnStationId(returnStationId);
        bikeTrip.setReturnStationName(returnStationName);
        bikeTrip.setCoveredDistanceInMeter(coveredDistanceInMeter);
        bikeTrip.setDurationInSec(durationInSec);

        return ResponseEntity.ok(bikeTripService.saveBikeStrip(bikeTrip));
    }

    @PostMapping("/savebikestation")
    public ResponseEntity<BikeStation> saveBikeStation(@RequestParam("id") int id, @RequestParam("name") String name,
            @RequestParam("address") String address, @RequestParam("city") String city,
            @RequestParam("operator") String operator, @RequestParam("capacity") int capacity,
            @RequestParam("xCoordinate") float xCoordinate, @RequestParam("yCoordinate") float yCoordinate) {

        BikeStation bikeStation = new BikeStation();
        bikeStation.setId(id);
        bikeStation.setName(name);
        bikeStation.setAddress(address);
        bikeStation.setCity(city);
        bikeStation.setOperator(operator);
        bikeStation.setCapacity(capacity);
        bikeStation.setxCoordinate(xCoordinate);
        bikeStation.setyCoordinate(yCoordinate);

        return ResponseEntity.ok(bikeStationService.saveBikeStation(bikeStation));
    }

}
