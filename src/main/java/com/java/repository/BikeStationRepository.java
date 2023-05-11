package com.java.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.bean.DepartureStationAggregate;
import com.java.bean.ReturnStationAggregate;
import com.java.entity.BikeStation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BikeStationRepository extends JpaRepository<BikeStation, Integer> {
    public List<BikeStation> findByNameStartsWith(String name);

    public Page<BikeStation> findByNameStartsWith(String name, Pageable pageable);

    public boolean existsByName(String name);

    public BikeStation findByName(String name);

    @Query("SELECT NEW com.java.bean.ReturnStationAggregate( COUNT(RBT.returnStationId), AVG(RBT.coveredDistanceInMeter) ) "
            + "FROM bikestationdetails BSD LEFT JOIN BSD.returnBikeTrip RBT  " + "WHERE BSD.name = :returnStationName")
    public ReturnStationAggregate findReturnStationAggregate(@Param("returnStationName") String returnStationName);

    @Query("SELECT NEW com.java.bean.ReturnStationAggregate( COUNT(RBT.returnStationId), AVG(RBT.coveredDistanceInMeter) ) "
            + "FROM bikestationdetails BSD LEFT JOIN BSD.returnBikeTrip RBT  "
            + "WHERE BSD.name = :returnStationName AND (RBT.returnTime BETWEEN :startDate AND :endDate)")
    public ReturnStationAggregate findReturnStationAggregate(@Param("returnStationName") String returnStationName,
            @Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

    @Query("SELECT NEW com.java.bean.DepartureStationAggregate( COUNT(DBT.departureStationId), AVG(DBT.coveredDistanceInMeter) ) "
            + "FROM bikestationdetails BSD LEFT JOIN BSD.depatureBikeTrip DBT  "
            + "WHERE BSD.name = :departureStationName")
    public DepartureStationAggregate findDepartureStationAggregate(
            @Param("departureStationName") String departureStationName);

    @Query("SELECT NEW com.java.bean.DepartureStationAggregate( COUNT(DBT.departureStationId), AVG(DBT.coveredDistanceInMeter) ) "
            + "FROM bikestationdetails BSD LEFT JOIN BSD.depatureBikeTrip DBT  "
            + "WHERE BSD.name = :departureStationName AND (DBT.departureTime BETWEEN :startDate AND :endDate)")
    public DepartureStationAggregate findDepartureStationAggregate(
            @Param("departureStationName") String departureStationName, @Param("startDate") Timestamp startDate,
            @Param("endDate") Timestamp endDate);

    @Query("SELECT MIN(RBT.departureStationName) AS DepartureStation " + "FROM bikestationdetails BSD "
            + "LEFT JOIN BSD.returnBikeTrip RBT " + "WHERE BSD.name = :stationName "
            + "GROUP BY RBT.departureStationId " + "ORDER BY COUNT(RBT.departureStationId) DESC")
    public List<String> getTopDepartureStationNames(@Param("stationName") String stationName, Pageable pageable);

    @Query("SELECT MIN(RBT.departureStationName) AS DepartureStation " + "FROM bikestationdetails BSD "
            + "LEFT JOIN BSD.returnBikeTrip RBT "
            + "WHERE BSD.name = :stationName AND (RBT.returnTime BETWEEN :startDate AND :endDate) "
            + "GROUP BY RBT.departureStationId " + "ORDER BY COUNT(RBT.departureStationId) DESC")
    public List<String> getTopDepartureStationNames(@Param("stationName") String stationName,
            @Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, Pageable pageable);

    @Query("SELECT MIN(DBT.returnStationName) AS ReturnStation " + "FROM bikestationdetails BSD "
            + "LEFT JOIN BSD.depatureBikeTrip DBT " + "WHERE BSD.name = :stationName " + "GROUP BY DBT.returnStationId "
            + "ORDER BY COUNT(DBT.returnStationId) DESC")
    public List<String> getTopReturnStationNames(@Param("stationName") String stationName, Pageable pageable);

    @Query("SELECT MIN(DBT.returnStationName) AS ReturnStation " + "FROM bikestationdetails BSD "
            + "LEFT JOIN BSD.depatureBikeTrip DBT "
            + "WHERE BSD.name = :stationName AND (DBT.departureTime BETWEEN :startDate AND :endDate) "
            + "GROUP BY DBT.returnStationId " + "ORDER BY COUNT(DBT.returnStationId) DESC")
    public List<String> getTopReturnStationNames(@Param("stationName") String stationName,
            @Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, Pageable pageable);
}
