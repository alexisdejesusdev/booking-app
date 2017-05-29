package com.luxoft.booking.model;

/**
 * Model for a customer.
 * 
 * @author Alexis De Jesús
 *
 */
public class Customer {
	private String id;
	private String fullName;

	
	// Setters and getters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
