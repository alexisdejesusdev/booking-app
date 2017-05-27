package com.luxoft.booking.controller;

import javax.servlet.http.HttpServletRequest;

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
	@Autowired
	private BookingService bookingService;

	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public Trip bookTrip(@RequestBody Trip trip, HttpServletRequest request) throws ControlledException {
		Trip response = bookingService.bookTrip(trip);

		return response;
	}
}
