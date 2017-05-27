package com.luxoft.booking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.luxoft.booking.model.Hotel;
import com.luxoft.booking.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Override
	public Hotel add(Hotel hotel) {
		// TODO Auto-generated method stub
		return new Hotel();
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Hotel>();
	}

}
