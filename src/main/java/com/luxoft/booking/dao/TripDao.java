package com.luxoft.booking.dao;

import com.luxoft.booking.model.Trip;
import com.luxoft.booking.model.exception.ControlledException;

/**
 * Contract for DAO trip operations.
 * 
 * @author Alexis De Jesús
 *
 */
public interface TripDao {
	/**
	 * Adds a trip to a specific repository.
	 * 
	 * @param trip
	 * @return
	 * @throws ControlledException
	 */
	public abstract Trip add(Trip trip) throws ControlledException;
}
