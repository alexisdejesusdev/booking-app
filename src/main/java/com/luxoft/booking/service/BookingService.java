package com.luxoft.booking.service;

import com.luxoft.booking.model.Trip;
import com.luxoft.booking.model.exception.ControlledException;

/**
 * Main contract for the booking service operations.
 * 
 * @author Alexis De Jesús
 *
 */
public interface BookingService {
	/**
	 * Books a trip given the specific trip model provided.
	 * 
	 * @param trip
	 * @return
	 * @throws ControlledException
	 */
	public abstract Trip bookTrip(Trip trip) throws ControlledException;
}
