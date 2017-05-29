package com.luxoft.booking.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.luxoft.booking.dao.HotelDao;
import com.luxoft.booking.model.Hotel;
import com.luxoft.booking.model.exception.ControlledException;
import com.luxoft.booking.model.util.HotelRecords;
import com.luxoft.booking.service.util.JsonServiceUtil;
import com.luxoft.booking.service.util.ResourceServiceUtil;

/**
 * Default DAO implementation to work with a JSON file as a database.
 * 
 * @author Alexis De Jesús
 *
 */
@Repository
public class HotelJsonFileDaoImpl implements HotelDao {
	private final static Log logger = LogFactory.getLog(HotelJsonFileDaoImpl.class);

	private static Properties globalProperties;
	private static String hotelRecordsJsonPath;

	static {
		try {
			globalProperties = ResourceServiceUtil.getProperties("config/persistence.properties");

			hotelRecordsJsonPath = globalProperties.getProperty("persistence.path")
					+ System.getProperty("file.separator") + "hotelRecords.json";

			if (logger.isDebugEnabled()) {
				logger.debug("Successfully loaded the database file [" + hotelRecordsJsonPath + "]. ");
			}

		} catch (ControlledException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public synchronized Hotel add(Hotel hotel) throws ControlledException {
		List<Hotel> records = getAll();

		if (records == null) {
			records = new ArrayList<Hotel>();
		}

		if (!records.contains(hotel)) {
			records.add(hotel);

			String json = JsonServiceUtil.toJson(new HotelRecords(records));

			ResourceServiceUtil.saveTextToFile(hotelRecordsJsonPath, json);

			if (logger.isInfoEnabled()) {
				logger.info("Successfully added a hotel to the database file. ");
			}

		} else {
			throw new ControlledException("The database already contains a hotel with the same Id. ");
		}

		return hotel;
	}

	@Override
	public synchronized List<Hotel> getAll() throws ControlledException {
		List<Hotel> records = null;

		String json = ResourceServiceUtil.getExternalResourceString(hotelRecordsJsonPath);

		HotelRecords persisted = JsonServiceUtil.fromJson(json, HotelRecords.class);

		records = persisted.getRecords();

		if (logger.isInfoEnabled()) {
			logger.info("Successfully retrieved all hotels from the database file. ");
		}

		return records;
	}
}
