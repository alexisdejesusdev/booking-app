package com.luxoft.booking.model;

import com.luxoft.booking.model.util.TripType;

public class Trip {
	private TripType type;
	private Hotel hotel;
	private Double cost;
	private Double discount;
	private Double finalPrice;
	private CreditCard creditCard;
	private String details;
	private Character currencySymbol;

	// Setters and getters
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
