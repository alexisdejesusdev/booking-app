package com.luxoft.booking.service.util;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luxoft.booking.model.exception.ControlledException;

/**
 * Utility class to work with json strings.
 * 
 * @author Alexis De Jesús
 *
 */
public class JsonServiceUtil {
	private static final Log logger = LogFactory.getLog(JsonServiceUtil.class);

	/**
	 * Transforms any object to it's json representation.
	 * 
	 * @param object
	 * @return
	 * @throws ControlledException
	 */
	public static String toJson(Object object) throws ControlledException {
		if (logger.isDebugEnabled()) {
			logger.debug("Trying to transform an object to json [" + object + "]. ");
		}

		String json = null;

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

		try {
			json = mapper.writeValueAsString(object);

		} catch (JsonGenerationException e) {
			throw new ControlledException("Error transforming the object to json. ", e);
		} catch (JsonMappingException e) {
			throw new ControlledException("Error transforming the object to json. ", e);
		} catch (IOException e) {
			throw new ControlledException("Error transforming the object to json. ", e);
		}

		return json;
	}

	/**
	 * Transforms any json to it's object representation, given the appropriate class.
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 * @throws ControlledException
	 */
	public static <T> T fromJson(String json, Class<T> clazz) throws ControlledException {
		if (logger.isDebugEnabled()) {
			logger.debug("Trying to transform a json string to an object [" + json + "]. ");
		}

		if (json == null || json.equals("")) {
			throw new ControlledException("Error transforming a json to object. It cannot be empty or null. ");
		}

		T object = null;

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		try {
			object = mapper.readValue(json, clazz);

		} catch (JsonGenerationException e) {
			throw new ControlledException("Error transforming the json to object.", e);
		} catch (JsonMappingException e) {
			throw new ControlledException("Error transforming the json to object.", e);
		} catch (IOException e) {
			throw new ControlledException("Error transforming the json to object.", e);
		}

		return object;
	}
}
