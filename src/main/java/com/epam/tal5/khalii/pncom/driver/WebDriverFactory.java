package com.epam.tal5.khalii.pncom.driver;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory extends AbstactDriverFactory {

    @Override
    public WebDriver getDriver(String parameter){
        if (parameter.equalsIgnoreCase("FF")){
                return BrowserRunner.runFirefox();
        } else if (parameter.equalsIgnoreCase("IE")){
            return BrowserRunner.runInternetExplorer();
        } else if (parameter.equalsIgnoreCase("Opera")){
            return BrowserRunner.runOpera();
        } else if (parameter.equalsIgnoreCase("Chrome")){
            return BrowserRunner.runChrome();
        } else if (parameter.equalsIgnoreCase("UnitHTML")){
            return BrowserRunner.runHtmlUnit();
        }
        throw new IllegalArgumentException("This browser is undefined!");
    }
}
