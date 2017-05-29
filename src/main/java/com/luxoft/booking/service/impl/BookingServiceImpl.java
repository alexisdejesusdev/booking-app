package com.luxoft.booking.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxoft.booking.dao.TripDao;
import com.luxoft.booking.model.Hotel;
import com.luxoft.booking.model.Trip;
import com.luxoft.booking.model.exception.ControlledException;
import com.luxoft.booking.service.BookingService;
import com.luxoft.booking.service.HotelService;

/**
 * Default booking service contract operations.
 * 
 * @author Alexis De Jesús
 *
 */
@Service
public class BookingServiceImpl implements BookingService {
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private TripDao tripDao;

	@Autowired
	private HotelService hotelService;

	@Override
	public Trip bookTrip(Trip trip) throws ControlledException {
		Trip stored = tripDao.add(trip);

		// Temporarily just populate the full model of hotels from the
		// appropriate service
		List<Hotel> hotels = hotelService.getAll();

		if (hotels != null) {
			for (Hotel h : hotels) {
				if (h.getId().equals(trip.getHotel().getId())) {
					stored.getHotel().setName(h.getName());
					break;
				}
			}
		}
		
		if (this.logger.isDebugEnabled()) {
			this.logger.debug("Successfully booked a new trip [" + stored + "]. ");
		}

		return stored;
	}

}
