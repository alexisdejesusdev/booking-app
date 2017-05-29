package com.luxoft.booking.service.impl;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luxoft.booking.model.Hotel;
import com.luxoft.booking.model.exception.ControlledException;
import com.luxoft.booking.service.HotelService;
import com.luxoft.booking.service.util.ResourceServiceUtil;

/**
 * Temporarily just test the service layer as a prototype of how unit test would
 * be made.
 * 
 * @author Alexis De Jesús
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class HotelServiceImplTest {
	private static Properties globalProperties;
	private static String hotelRecordsJsonPath;

	private static String databaseContent;

	static {
		try {
			globalProperties = ResourceServiceUtil.getProperties("config/persistence.properties");

			hotelRecordsJsonPath = globalProperties.getProperty("persistence.path")
					+ System.getProperty("file.separator") + "hotelRecords.json";

			databaseContent = ResourceServiceUtil.getExternalResourceString(hotelRecordsJsonPath);

		} catch (ControlledException e) {
			throw new RuntimeException(e);
		}
	}

	@Autowired
	private HotelService service;

	@Before
	public void cleanUpDatabase() throws ControlledException {
		ResourceServiceUtil.saveTextToFile(hotelRecordsJsonPath, "{}");
	}

	@Test
	public void addHotelSuccess() throws ControlledException {
		// Create a successful model
		Hotel hotel = new Hotel();
		hotel.setId("1");
		hotel.setName("one");

		// Call the service
		service.add(hotel);

		// Always assert true since an exception will be thrown if an error
		assertTrue(true);
	}

	@Test(expected = ControlledException.class)
	public void addHotelErrorAlreadyExists() throws ControlledException {
		// Create a successful model
		Hotel hotel = new Hotel();
		hotel.setId("1");
		hotel.setName("one");

		// Call the service
		service.add(hotel);

		// Create a successful model
		hotel = new Hotel();
		hotel.setId("1");
		hotel.setName("one");

		// Call the service
		service.add(hotel);
	}

	@Test
	public void getAllHotelsSuccess() throws ControlledException {
		// Create a successful model
		Hotel hotel = new Hotel();
		hotel.setId("1");
		hotel.setName("one");

		// Call the service
		service.add(hotel);

		// Call the service
		List<Hotel> hotels = service.getAll();

		// Validate that the database has data
		assertNotNull(hotels);
		assertFalse(hotels.isEmpty());
	}

	@Test
	public void getAllHotelsErrorDatabaseEmpty() throws ControlledException {
		// Call the service
		List<Hotel> hotels = service.getAll();

		// Validate that the database does not have data
		assertNull(hotels);
	}

	@AfterClass
	public static void resetDatabase() throws ControlledException {
		ResourceServiceUtil.saveTextToFile(hotelRecordsJsonPath, databaseContent);
	}
}
