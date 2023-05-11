package com.java.service;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.entity.BikeTrip;
import com.java.repository.BikeTripRepository;

@Service
public class BikeTripService {

    @Autowired
    private BikeTripRepository bikeTripRepository;

    public HashMap<String, Object> getAllBikeTrips(int page, int size, String sortingColumn, boolean isAscending) {

        PageRequest pagable;

        if (isAscending) {
            pagable = PageRequest.of(page, size, Sort.by(sortingColumn).ascending());

        } else {
            pagable = PageRequest.of(page, size, Sort.by(sortingColumn).descending());
        }

        Page<BikeTrip> bikeTripPage = bikeTripRepository.findAll(pagable);

        HashMap<String, Object> tempMap = new HashMap<String, Object>();
        tempMap.put("pageContent", bikeTripPage.getContent());
        tempMap.put("totalPages", bikeTripPage.getTotalPages());

        return tempMap;
    }

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
