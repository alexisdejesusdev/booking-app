package com.luxoft.booking.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.luxoft.booking.dao.TripDao;
import com.luxoft.booking.model.Trip;
import com.luxoft.booking.model.exception.ControlledException;
import com.luxoft.booking.model.util.TripRecords;
import com.luxoft.booking.service.util.JsonServiceUtil;
import com.luxoft.booking.service.util.ResourceServiceUtil;

/**
 * Default DAO implementation to work with a JSON file as a database.
 * 
 * @author Alexis De Jesús
 *
 */
@Repository
public class TripJsonFileDaoImpl implements TripDao {
	private static final Log logger = LogFactory.getLog(TripJsonFileDaoImpl.class);

	private static Properties globalProperties;
	private static String tripRecordsJsonPath;

	static {
		try {
			globalProperties = ResourceServiceUtil.getProperties("config/persistence.properties");

			tripRecordsJsonPath = globalProperties.getProperty("persistence.path")
					+ System.getProperty("file.separator") + "tripRecords.json";

			if (logger.isDebugEnabled()) {
				logger.debug("Successfully loaded the database file [" + tripRecordsJsonPath + "]. ");
			}

		} catch (ControlledException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public synchronized Trip add(Trip trip) throws ControlledException {
		List<Trip> records = getAll();

		if (records == null) {
			records = new ArrayList<Trip>();

			trip.setId(1L);

		} else {
			trip.setId(records.size() + 1L);
		}

		if (!records.contains(trip)) {
			records.add(trip);

			String json = JsonServiceUtil.toJson(new TripRecords(records));

			ResourceServiceUtil.saveTextToFile(tripRecordsJsonPath, json);

			if (logger.isInfoEnabled()) {
				logger.info("Successfully added a trip to the database file. ");
			}

		} else {
			throw new ControlledException("The database already contains a trip with the same Id. ");
		}

		return trip;
	}

	private synchronized List<Trip> getAll() throws ControlledException {
		List<Trip> records = null;

		String json = ResourceServiceUtil.getExternalResourceString(tripRecordsJsonPath);

		TripRecords persisted = JsonServiceUtil.fromJson(json, TripRecords.class);

		records = persisted.getRecords();

		if (logger.isInfoEnabled()) {
			logger.info("Successfully retrieved all trips from the database file. ");
		}

		return records;
	}
}
