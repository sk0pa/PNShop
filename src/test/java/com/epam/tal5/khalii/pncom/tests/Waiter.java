package com.epam.tal5.khalii.pncom.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    public static WebElement getByCss(WebDriver driver, String selector){
        return new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.
                cssSelector(selector)));
    }

    public static WebElement getByXpath(WebDriver driver, String xpath){
        return new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.
                xpath(xpath)));
    }

    public static WebElement getById(WebDriver driver, String id){
        return new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.
                id(id)));
    }

    public static WebElement getByName(WebDriver driver, String name){
        return new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.
                name(name)));
    }

    public static boolean isElementPresentByXpath(WebDriver driver, String xpath){
        return !driver.findElements(By.xpath(xpath)).isEmpty();
    }
}
