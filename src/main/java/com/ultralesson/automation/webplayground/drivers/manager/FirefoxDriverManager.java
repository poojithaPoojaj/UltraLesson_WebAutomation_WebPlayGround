package com.ultralesson.automation.webplayground.drivers.manager;

import com.google.common.collect.ImmutableMap;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverManager implements DriverManager<WebDriver> {

    @Override
    public WebDriver create(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();

    }
    public WebDriver createMobile() {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("moz:firefoxOptions", ImmutableMap.of("mobileEmulation", ImmutableMap.of("deviceName", "iPhone X")));
        return new FirefoxDriver(options);
    }
}
