package com.example.bike_journeys_backend.test;

import com.java.controller.RestController;
import com.java.entity.BikeTrip;
import com.java.service.BikeTripService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RestControllerTest {

	@Mock
	private BikeTripService bikeTripService;

	@InjectMocks
	private RestController restController;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
	}

	@Test
	public void testGetAllBikeTrips() throws Exception {

		int pageNumber = 0;
		int numberOfTrips = 10;
		String sortingColumn = "departureTime";
		boolean isAscending = true;
		BikeTrip bikeTrip = new BikeTrip();
		// Seting properties of the bike trip

		bikeTrip.setId(1);
		bikeTrip.setDepartureTime(Timestamp.valueOf("2021-01-01 00:00:00"));
		bikeTrip.setReturnTime(Timestamp.valueOf("2021-02-02 00:00:00"));
		bikeTrip.setDepartureStationId(1);
		bikeTrip.setDepartureStationName("Departure Station Name");
		bikeTrip.setReturnStationId(1);
		bikeTrip.setReturnStationName("Return Station Name");
		bikeTrip.setCoveredDistanceInMeter(3000f);
		bikeTrip.setDurationInSec(1000f);
		List<BikeTrip> bikeTrips = Arrays.asList(bikeTrip);
		HashMap<String, Object> response = new HashMap<>();
		response.put("data", bikeTrips);

		// Mocking the service method
		when(bikeTripService.getAllBikeTrips(pageNumber, numberOfTrips, sortingColumn, isAscending))
				.thenReturn(response);

		// Performing the GET request
		ResultActions resultActions = mockMvc.perform(get("/getalltrips")
				.param("pagenumber", String.valueOf(pageNumber))
				.param("numberoftrips", String.valueOf(numberOfTrips))
				.param("sortingcolumn", sortingColumn)
				.param("isascending", String.valueOf(isAscending)));

		// Asserting the response
		resultActions.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.data[0].id").value(bikeTrip.getId()))
				.andExpect(jsonPath("$.data[0].departureTime").value(bikeTrip.getDepartureTime().getTime()))
				.andExpect(jsonPath("$.data[0].returnTime").value(bikeTrip.getReturnTime().getTime()))
				.andExpect(jsonPath("$.data[0].departureStationId").value(bikeTrip.getDepartureStationId()))
				.andExpect(jsonPath("$.data[0].departureStationName").value(bikeTrip.getDepartureStationName()))
				.andExpect(jsonPath("$.data[0].returnStationId").value(bikeTrip.getReturnStationId()))
				.andExpect(jsonPath("$.data[0].returnStationName").value(bikeTrip.getReturnStationName()))
				.andExpect(jsonPath("$.data[0].coveredDistanceInMeter").value(bikeTrip.getCoveredDistanceInMeter()))
				.andExpect(jsonPath("$.data[0].durationInSec").value(bikeTrip.getDurationInSec()))
				.andReturn();
	}

	@Test
	public void testGetBikeTripById() throws Exception {
		// Preparing mock data
		int bikeTripId = 1;
		BikeTrip bikeTrip = new BikeTrip();

		// Seting properties of the bike trip
		bikeTrip.setId(1);
		bikeTrip.setDepartureTime(new Timestamp(System.currentTimeMillis()));
		bikeTrip.setReturnTime(new Timestamp(System.currentTimeMillis()));
		bikeTrip.setDepartureStationId(1);
		bikeTrip.setDepartureStationName("Departure Station");
		bikeTrip.setReturnStationId(2);
		bikeTrip.setReturnStationName("Return Station");
		bikeTrip.setCoveredDistanceInMeter(5000.0f);
		bikeTrip.setDurationInSec(1800.0f);

		// Mocking the service method
		when(bikeTripService.getBikeTripById(bikeTripId)).thenReturn(bikeTrip);

		// Performing the GET request
		ResultActions resultActions = mockMvc.perform(get("/gettripbyid")
				.param("id", String.valueOf(bikeTripId)));

		// Assertng the response
		resultActions.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.id").value(bikeTrip.getId()))
				.andExpect(jsonPath("$.departureTime").exists())
				.andExpect(jsonPath("$.returnTime").exists())
				.andExpect(jsonPath("$.departureStationId").value(bikeTrip.getDepartureStationId()))
				.andExpect(jsonPath("$.departureStationName").value(bikeTrip.getDepartureStationName()))
				.andExpect(jsonPath("$.returnStationId").value(bikeTrip.getReturnStationId()))
				.andExpect(jsonPath("$.returnStationName").value(bikeTrip.getReturnStationName()))
				.andExpect(jsonPath("$.coveredDistanceInMeter").value(bikeTrip.getCoveredDistanceInMeter()))
				.andExpect(jsonPath("$.durationInSec").value(bikeTrip.getDurationInSec()))
				.andReturn();
	}

}
