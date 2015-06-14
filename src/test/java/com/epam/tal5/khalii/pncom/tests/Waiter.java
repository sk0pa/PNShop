package com.epam.tal5.khalii.pncom.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    public static WebElement waitForElementPresentsByXpath(WebDriver driver, String xpath){
        return new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.
                xpath(xpath)));
    }
}
