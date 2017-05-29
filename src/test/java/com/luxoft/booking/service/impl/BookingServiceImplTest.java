package com.luxoft.booking.service.impl;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luxoft.booking.model.Trip;
import com.luxoft.booking.model.exception.ControlledException;
import com.luxoft.booking.service.BookingService;
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
public class BookingServiceImplTest {
	private static Properties globalProperties;
	private static String tripRecordsJsonPath;

	private static String databaseContent;

	static {
		try {
			globalProperties = ResourceServiceUtil.getProperties("config/persistence.properties");

			tripRecordsJsonPath = globalProperties.getProperty("persistence.path")
					+ System.getProperty("file.separator") + "hotelRecords.json";

			databaseContent = ResourceServiceUtil.getExternalResourceString(tripRecordsJsonPath);

		} catch (ControlledException e) {
			throw new RuntimeException(e);
		}
	}

	@Autowired
	private BookingService service;

	@Before
	public void cleanUpDatabase() throws ControlledException {
		ResourceServiceUtil.saveTextToFile(tripRecordsJsonPath, "{}");
	}

	@Test
	public void addTripSuccess() throws ControlledException {
		// Create a successful model
		Trip trip = new Trip();
		trip.setCost(1000.50);

		// Call the service
		service.bookTrip(trip);

		// Always assert true since an exception will be thrown if an error
		assertTrue(true);
	}

	@Test(expected = NullPointerException.class)
	public void addTripError() throws ControlledException {
		// Call the service
		service.bookTrip(null);
	}

	@AfterClass
	public static void resetDatabase() throws ControlledException {
		ResourceServiceUtil.saveTextToFile(tripRecordsJsonPath, databaseContent);
	}

}
