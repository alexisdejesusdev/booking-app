package com.luxoft.booking.model;

import com.luxoft.booking.model.util.TripType;

/**
 * Model for a trip.
 * 
 * @author Alexis De Jesús
 *
 */
public class Trip {
	private Long id;
	private TripType type;
	private Hotel hotel;
	private Double cost;
	private Double discount;
	private Double finalPrice;
	private CreditCard creditCard;
	private Character currencySymbol;
	private String details;

	@Override
	public boolean equals(Object obj) {
		boolean equal = false;

		if (obj instanceof Trip) {
			if (this.id.equals(((Trip) obj).getId())) {
				equal = true;
			}
		}

		return equal;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		sb.append("id: ").append(this.id).append(", ");
		sb.append("type: ").append(this.type).append(", ");
		sb.append("hotel: ").append(this.hotel).append(", ");
		sb.append("cost:").append(this.cost).append(", ");
		sb.append("discount: ").append(this.discount).append(", ");
		sb.append("finalPrice: ").append(this.finalPrice).append(", ");
		sb.append("creditCard: ").append(this.creditCard).append(", ");
		sb.append("currencySymbol: ").append(this.currencySymbol).append(", ");
		sb.append("details: ").append(this.details);
		sb.append("}");

		return sb.toString();
	}

	// Setters and getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TripType getType() {
		return type;
	}

	public void setType(TripType type) {
		this.type = type;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Character getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(Character currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
}
