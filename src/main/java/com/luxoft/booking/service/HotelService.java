package com.luxoft.booking.service;

import java.util.List;

import com.luxoft.booking.model.Hotel;

public interface HotelService {
	public abstract Hotel add(Hotel hotel);
	public abstract List<Hotel> getAll();
}
