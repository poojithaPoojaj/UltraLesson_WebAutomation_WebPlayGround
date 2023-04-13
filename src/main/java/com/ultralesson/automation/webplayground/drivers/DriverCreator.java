package com.ultralesson.automation.webplayground.drivers;

import com.ultralesson.automation.webplayground.drivers.manager.ChromeDriverManager;
import com.ultralesson.automation.webplayground.drivers.manager.DriverManager;
import com.ultralesson.automation.webplayground.drivers.manager.EdgeDriverManager;
import com.ultralesson.automation.webplayground.drivers.manager.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DriverCreator {
    public WebDriver create(String browser) {
        browser = setDefaultBrowser(browser);
        switch (browser.toLowerCase()) {
            case "firefox":
                return new FirefoxDriverManager().create();
            case "edge":
                return new EdgeDriverManager().create();
            default:
                WebDriver webDriver = new ChromeDriverManager().create();
                return webDriver;
        }

    }


    private String setDefaultBrowser(String browser) {
        if(Objects.isNull(browser) || browser.isEmpty()) {
            browser = "chrome";
        }
        return browser;
    }
    public WebDriver createMobile(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                return new FirefoxDriverManager().createMobile();
            default:
                return new ChromeDriverManager().createMobile();

        }
    }
    public WebDriverContext createDriverContext(String browser) {
        browser=System.getProperty("browser", "chrome");
        DriverManager<WebDriver> webDriverDriverManager = getBrowserManagers().get(browser);
        return new WebDriverContext(webDriverDriverManager);
    }
    public Map<String, DriverManager<WebDriver>> getBrowserManagers() {
        Map<String,DriverManager<WebDriver>> driverManagerMap = new HashMap<>();
        driverManagerMap.put("chrome", new ChromeDriverManager());
        driverManagerMap.put("firefox", new FirefoxDriverManager());
        driverManagerMap.put("edge", new EdgeDriverManager());
        return driverManagerMap;
    }
}
