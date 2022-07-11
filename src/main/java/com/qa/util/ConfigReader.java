package com.qa.util;
import com.qa.constants.FrameWorkConstants;
import com.qa.enums.ConfigProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * Read the property file and store it in a HashMap for faster processing.
 * Users can prefer to use json instead of property file based on their requirement.
 * @author rajasekhar
 *
 */
public final class ConfigReader {
	private ConfigReader() {
	}

	private static Properties prop = new Properties();
	private static final Map<String, String> CONFIGMAP= new HashMap<String, String>();
	
	static {
		try(FileInputStream fis = new FileInputStream(FrameWorkConstants.getPropertyfilepath())) {
			prop.load(fis);
			for(Map.Entry<Object, Object> entry : prop.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * Receives the {@link ConfigProperty},converts to lowercase , return the corresponding value
	 * for the key from the HashMap
	 * @author rajasekhar
	 * @param key To be fetched from property file
	 */
	public static String getValue(ConfigProperty key) {
		if(Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new RuntimeException("Property with the "+key+ " is not found ");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

	
	 
	 

}
