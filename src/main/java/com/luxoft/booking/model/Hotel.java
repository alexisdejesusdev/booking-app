package com.luxoft.booking.model;

public class Hotel {
	private String id;
	private String name;
	private Boolean isMerchant;
	private String details;
	private String link;
	private Float discount;

	// Setter and getters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsMerchant() {
		return isMerchant;
	}

	public void setIsMerchant(Boolean isMerchant) {
		this.isMerchant = isMerchant;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}
}
