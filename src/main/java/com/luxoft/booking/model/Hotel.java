package com.luxoft.booking.model;

/**
 * Model for a hotel.
 * 
 * @author Alexis De Jesús
 *
 */
public class Hotel {
	private String id;
	private String name;
	private Boolean isMerchant;
	private String details;
	private String link;
	private Float discount;

	@Override
	public boolean equals(Object obj) {
		boolean equal = false;

		if (obj instanceof Hotel) {
			if (this.id.equals(((Hotel) obj).getId())) {
				equal = true;
			}
		}

		return equal;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		sb.append("id: ").append(this.id).append(", ");
		sb.append("name: ").append(this.name).append(", ");
		sb.append("isMerchant: ").append(this.isMerchant).append(", ");
		sb.append("details: ").append(this.details).append(", ");
		sb.append("link: ").append(this.link).append(", ");
		sb.append("discount: ").append(this.discount);
		sb.append("}");
		
		return sb.toString();
	}

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
