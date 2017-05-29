package com.luxoft.booking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.luxoft.booking.model.Hotel;
import com.luxoft.booking.model.exception.ControlledException;
import com.luxoft.booking.service.HotelService;

/**
 * REST endpoint for hotel operations.
 * 
 * @author Alexis De Jesús
 *
 */
@RestController
public class HotelController {
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private HotelService hotelService;

	/**
	 * Adds a new hotel given the completeness of the model. 
	 * 
	 * @param hotel
	 * @param request
	 * @return
	 * @throws ControlledException
	 */
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value = "/hotel", method = RequestMethod.POST)
	public Hotel add(@RequestBody Hotel hotel, HttpServletRequest request) throws ControlledException {
		if (this.logger.isInfoEnabled()) {
			this.logger.info("Received request to add a hotel [" + hotel + "]. ");
		}
		
		Hotel response = hotelService.add(hotel);

		return response;
	}

	/**
	 * Retrieves all the hotels persisted from the service. 
	 * 
	 * @param request
	 * @return
	 * @throws ControlledException
	 */
	@ResponseBody
	@RequestMapping(value = "/hotel", method = RequestMethod.GET)
	public List<Hotel> getAll(HttpServletRequest request) throws ControlledException {
		if (this.logger.isInfoEnabled()) {
			this.logger.info("Received request to get all hotels. ");
		}
		
		List<Hotel> response = hotelService.getAll();

		return response;
	}
}
