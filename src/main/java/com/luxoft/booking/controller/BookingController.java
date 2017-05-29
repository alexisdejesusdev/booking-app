package com.luxoft.booking.controller;

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

import com.luxoft.booking.model.Trip;
import com.luxoft.booking.model.exception.ControlledException;
import com.luxoft.booking.service.BookingService;

/**
 * REST endpoint for booking operations.
 * 
 * @author Alexis De Jesús
 *
 */
@RestController
public class BookingController {
	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private BookingService bookingService;

	/**
	 * Books a trip and returns an instance of that trip with the corresponding
	 * id assigned by the service.
	 * 
	 * @param trip
	 * @param request
	 * @return
	 * @throws ControlledException
	 */
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public Trip bookTrip(@RequestBody Trip trip, HttpServletRequest request) throws ControlledException {
		if (this.logger.isInfoEnabled()) {
			this.logger.info("Received request to book a new trip [" + trip + "]. ");
		}

		Trip response = bookingService.bookTrip(trip);

		if (this.logger.isInfoEnabled()) {
			this.logger.info("Completed request to book a new trip [" + response + "]. ");
		}

		return response;
	}
}
