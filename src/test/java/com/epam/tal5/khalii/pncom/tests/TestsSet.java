package com.epam.tal5.khalii.pncom.tests;

import com.epam.tal5.khalii.pncom.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestsSet{
    public WebDriver driver;
    CompareOfMicrowave comparsionOfMicrowave ;
    PriceFilterTest priceFilterTest ;
    SortingByNameAndPrice sortingByNameAndPrice;


    @BeforeTest
    public void beforeSuite()
    {
        String browser = "chrome";
        WebDriverFactory driverFactory = new WebDriverFactory();
        driver = driverFactory.getDriver(browser);
    }

    @AfterTest
    public void afterSuite()
    {
        driver.quit();

    }
}
