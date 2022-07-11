package com.qa.constants;

import com.qa.enums.ConfigProperty;
import com.qa.util.ConfigReader;

/**
 * Framework Constants holds all the constant values used within the framework. If some value needs to be changed
 * or modified often, then it should be stored in the property files
 * 
 * @author rajasekhar
 *
 */
public final class FrameWorkConstants {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private FrameWorkConstants() {
	}
	private static final String RESOURCESPATH=System.getProperty("user.dir")+ "/src/test/resources";
	private static final String PROPERTYFILEPATH = RESOURCESPATH+"/config/config.properties";
	private static final int EXPLICITWAIT = 10;
	private static final String EXCELPATH = RESOURCESPATH+"/Excel/Automation.xlsx";
	public static String getExcelpath() {
		return EXCELPATH;
	}
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}
	public static String getResourcespath() {
		return RESOURCESPATH;
	}
	public static String getPropertyfilepath() {
		return PROPERTYFILEPATH;
	}



}
