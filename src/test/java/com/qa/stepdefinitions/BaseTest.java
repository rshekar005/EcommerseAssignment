package com.qa.stepdefinitions;

import com.qa.enums.ConfigProperty;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;


import java.util.Objects;

public class BaseTest {

    @Before
    public void launchBrowser() {
        DriverFactory.init_driver(ConfigReader.getValue(ConfigProperty.BROWSER));
    }

    //@After
    public void quitBrowser() {
        DriverFactory.getDriver().quit();
    }

}
