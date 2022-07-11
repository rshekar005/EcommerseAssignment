package com.qa.factory;

import com.qa.enums.ConfigProperty;
import com.qa.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public static WebDriver init_driver(String browser) {
		System.out.println("Browser name : " +browser);
		if(browser.equals("chrome")) {
			ChromeOptions options= new ChromeOptions();
			options.addArguments("--incognito");
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(options));
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Please pass the correct browser value : "+browser);
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(ConfigReader.getValue(ConfigProperty.URL));
		return getDriver();
	}
	
	/**
	 * This method is used to the driver of threadlocal
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
