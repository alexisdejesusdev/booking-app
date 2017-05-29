package com.luxoft.booking.service.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.luxoft.booking.model.exception.ControlledException;

/**
 * Utility class to work with resources inside and outside the classpath.
 * 
 * @author Alexis De Jesús
 *
 */
public class ResourceServiceUtil {
	private static final Log logger = LogFactory.getLog(ResourceServiceUtil.class);

	/**
	 * Gets a textual resource from outside the classpath given an absolute
	 * path.
	 * 
	 * @param path
	 * @return
	 * @throws ControlledException
	 */
	public static String getExternalResourceString(String path) throws ControlledException {
		String result = null;
		byte[] resourceBytes;

		try {
			resourceBytes = getExternalResourceBytes(path);
			result = new String(resourceBytes, "UTF-8");

		} catch (IOException e) {
			e.printStackTrace();
			throw new ControlledException("Error al cargar un archivo como cadena. " + path, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Successfully got a resource [" + path + "]. ");
		}

		return result;
	}

	/**
	 * Gets a textual resource from inside the classpath given a relative path.
	 * 
	 * @param path
	 * @return
	 * @throws ControlledException
	 */
	public static String getResourceString(String path) throws ControlledException {
		String result = null;
		byte[] resourceBytes;

		try {
			resourceBytes = getResourceBytes(path);
			result = new String(resourceBytes, "UTF-8");

		} catch (IOException e) {
			e.printStackTrace();
			throw new ControlledException("Error al cargar un archivo como cadena. " + path, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Successfully got a resource [" + path + "]. ");
		}

		return result;
	}

	/**
	 * Updates the text content of a resource from outside the classpath given
	 * an absolute path.
	 * 
	 * @param path
	 * @param content
	 * @throws ControlledException
	 */
	public static void saveTextToFile(String path, String content) throws ControlledException {
		File file = new File(path);

		FileWriter writer = null;

		try {
			writer = new FileWriter(file, false);
			writer.write(content);
			writer.flush();
			writer.close();

		} catch (IOException e) {
			throw new ControlledException("The requested file could not be saved. ", e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Successfully updated a resource [" + path + "]. ");
		}
	}

	/**
	 * Gets a java properties file given a relative path inside the classpath.
	 * 
	 * @param filename
	 * @return
	 * @throws ControlledException
	 */
	public static Properties getProperties(String filename) throws ControlledException {
		InputStream inputStream = null;
		Properties bundle = new Properties();

		try {
			inputStream = ResourceServiceUtil.getInputStream(filename);
			bundle.load(inputStream);

		} catch (NullPointerException e) {
			throw new ControlledException("Error al cargar un archivo de propiedades. " + filename, e);

		} catch (IOException e) {
			throw new ControlledException("Error al cargar un archivo de propiedades. " + filename, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Successfully got a properties file [" + filename + "]. ");
		}

		return bundle;
	}

	private static InputStream getInputStream(String path) throws IOException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = loader.getResourceAsStream(path);

		return inputStream;
	}

	private static InputStream getExternalInputStream(String path) throws IOException {
		InputStream inputStream = new FileInputStream(path);

		return inputStream;
	}

	private static byte[] getResourceBytes(String path) throws IOException {
		InputStream inputStream = getInputStream(path);
		byte[] result = inputStreamToByteArray(inputStream);

		return result;
	}

	private static byte[] getExternalResourceBytes(String path) throws IOException {
		InputStream inputStream = getExternalInputStream(path);
		byte[] result = inputStreamToByteArray(inputStream);

		return result;
	}

	private static byte[] inputStreamToByteArray(InputStream is) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int nRead;
		byte[] data = new byte[16384];

		while ((nRead = is.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}

		buffer.flush();

		return buffer.toByteArray();
	}
}
