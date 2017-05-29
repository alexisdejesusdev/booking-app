package com.luxoft.booking.dao;

import java.util.List;

import com.luxoft.booking.model.Hotel;
import com.luxoft.booking.model.exception.ControlledException;

/**
 * Contract for DAO hotel operations.
 * 
 * @author Alexis De Jesús
 *
 */
public interface HotelDao {
	/**
	 * Adds a hotel to a specific repository.
	 * 
	 * @param hotel
	 * @return
	 * @throws ControlledException
	 */
	public abstract Hotel add(Hotel hotel) throws ControlledException ;

	/**
	 * Retrieves all hotels from a specific repository.
	 * 
	 * @return
	 * @throws ControlledException
	 */
	public abstract List<Hotel> getAll() throws ControlledException ;
}
