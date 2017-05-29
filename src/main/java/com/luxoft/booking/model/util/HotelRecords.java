package com.luxoft.booking.model.util;

import java.util.List;

import com.luxoft.booking.model.Hotel;

/**
 * Utility class to wrap a list o hotels.
 * 
 * @author Alexis De Jesús
 *
 */
public class HotelRecords {
	private List<Hotel> records;
	
	public HotelRecords() {
		
	}
	
	public HotelRecords(List<Hotel> records) {
		this.records = records;
	}

	
	// Setters and Getters
	public List<Hotel> getRecords() {
		return records;
	}

	public void setRecords(List<Hotel> records) {
		this.records = records;
	}
}
