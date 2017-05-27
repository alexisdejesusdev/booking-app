package com.luxoft.booking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	@Autowired
	private HotelService hotelService;

	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value = "/hotel", method = RequestMethod.POST)
	public Hotel add(@RequestBody Hotel hotel, HttpServletRequest request) throws ControlledException {
		Hotel response = hotelService.add(hotel);

		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/hotel", method = RequestMethod.GET)
	public List<Hotel> getAll(HttpServletRequest request) throws ControlledException {
		List<Hotel> response = hotelService.getAll();

		return response;
	}
}
