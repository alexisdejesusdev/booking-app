package com.luxoft.booking.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxoft.booking.dao.HotelDao;
import com.luxoft.booking.model.Hotel;
import com.luxoft.booking.model.exception.ControlledException;
import com.luxoft.booking.service.HotelService;

/**
 * Default hotel service contract operations.
 * 
 * @author Alexis De Jesús
 *
 */
@Service
public class HotelServiceImpl implements HotelService {
	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private HotelDao hotelDao;

	@Override
	public Hotel add(Hotel hotel) throws ControlledException {
		Hotel stored = hotelDao.add(hotel);

		if (this.logger.isDebugEnabled()) {
			this.logger.debug("Successfully added a new hotel [" + stored + "]. ");
		}

		return stored;
	}

	@Override
	public List<Hotel> getAll() throws ControlledException {
		List<Hotel> hotels = hotelDao.getAll();

		if (this.logger.isDebugEnabled()) {
			this.logger.debug("Successfully retrieved all hotels [" + hotels + "]. ");
		}

		return hotels;
	}

}
