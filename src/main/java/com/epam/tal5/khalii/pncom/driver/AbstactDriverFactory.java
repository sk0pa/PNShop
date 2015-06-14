package com.epam.tal5.khalii.pncom.driver;

import org.openqa.selenium.WebDriver;

public abstract class AbstactDriverFactory {
    public abstract WebDriver getDriver(String parameter);
}
