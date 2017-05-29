package com.luxoft.booking.service;

import java.util.List;

import com.luxoft.booking.model.Hotel;
import com.luxoft.booking.model.exception.ControlledException;

/**
 * Main contract for the hotel service operations.
 * 
 * @author Alexis De Jesús
 *
 */
public interface HotelService {
	/**
	 * Adds a new hotel given the specific model provided.
	 * 
	 * @param hotel
	 * @return
	 * @throws ControlledException
	 */
	public abstract Hotel add(Hotel hotel) throws ControlledException;

	/**
	 * Retrieves all hotels from the corresponding implementation.
	 * 
	 * @return
	 * @throws ControlledException
	 */
	public abstract List<Hotel> getAll() throws ControlledException;
}
