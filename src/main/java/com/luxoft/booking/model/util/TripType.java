package com.luxoft.booking.model.util;

/**
 * Utility class for trip types.
 * 
 * @author Alexis De Jesús
 *
 */
public enum TripType {
	HOTEL("hotel");

	private String value;

	private TripType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {

		return this.value;
	}
}
