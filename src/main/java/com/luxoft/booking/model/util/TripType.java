package com.luxoft.booking.model.util;

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
