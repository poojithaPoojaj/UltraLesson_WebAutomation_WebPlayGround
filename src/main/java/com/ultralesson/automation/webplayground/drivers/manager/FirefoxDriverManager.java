package com.ultralesson.automation.webplayground.drivers.manager;

import org.openqa.selenium.WebDriver;

public class FirefoxDriverManager implements DriverManager {

    @Override
    public WebDriver create(){
        return new io.github.bonigarcia.wdm.managers.FirefoxDriverManager().create();
    }
}
