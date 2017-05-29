package com.luxoft.booking.model;

/**
 * Model for a credit card.
 * 
 * @author Alexis De Jesús
 *
 */
public class CreditCard {
	private Long number;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		sb.append("number: ").append(this.number);
		sb.append("}");

		return sb.toString();
	}

	// Setters and getters
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
}
