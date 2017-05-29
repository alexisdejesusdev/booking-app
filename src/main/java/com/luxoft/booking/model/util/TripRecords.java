package com.luxoft.booking.model.util;

import java.util.List;

import com.luxoft.booking.model.Trip;

/**
 * Utility class to wrap a list o trips.
 * 
 * @author Alexis De Jesús
 *
 */
public class TripRecords {
	private List<Trip> records;

	public TripRecords() {

	}

	public TripRecords(List<Trip> records) {
		this.records = records;
	}

	// Setters and Getters
	public List<Trip> getRecords() {
		return records;
	}

	public void setRecords(List<Trip> records) {
		this.records = records;
	}
}
