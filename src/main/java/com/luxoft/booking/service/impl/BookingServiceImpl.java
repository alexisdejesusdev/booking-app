package com.luxoft.booking.service.impl;

import org.springframework.stereotype.Service;

import com.luxoft.booking.model.Trip;
import com.luxoft.booking.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Override
	public Trip bookTrip(Trip trip) {
		// TODO Auto-generated method stub
		return new Trip();
	}

}
