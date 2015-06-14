package com.epam.tal5.khalii.pncom.steps;


import com.epam.tal5.khalii.pncom.pages.MainPage;
import com.epam.tal5.khalii.pncom.pages.ProductCatalog;
import com.epam.tal5.khalii.pncom.tests.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class PriceFilterSteps {
    ProductCatalog catalog;
    MainPage mainPage;

    public static final String MIN_PRICE_FILTER_12000 = "//div[contains(@class,'group')][1]//*[@class='is_empty_items']//a[contains(text(),'12000')]";
    public static final String MAX_PRICE_FILTER_18000 = "//div[contains(@class,'group')][2]//*[@class='is_empty_items']//a[contains(text(),'18000')]";
    public static final String LAST_SEARCH_PAGE = "//*[@class='custom_pn_pager']//*[contains(@class,'last')]/a ";
    public static final String FIRST_PRODUCT_PRICE = "//div[@class='item'][1]/div[@class='price']/strong";
    public static final String LAST_PRODUCT_PRICE = "//div[@class='item'][2]/div[@class='price']/strong";

    public PriceFilterSteps(WebDriver driver)
    {
        catalog = new ProductCatalog(driver);
        mainPage = new MainPage(driver);

    }

    public PriceFilterSteps navigateToWasherCatalog()
    {

        mainPage.navigateTo("http://pn.com.ua/");

        assertThat(mainPage.getDriver().getTitle(), containsString("Прайс навигатор"));

        catalog = mainPage.washerCategory();

        Waiter.waitForElementPresentsByXpath(mainPage.getDriver(),
                MIN_PRICE_FILTER_12000);

        assertThat(mainPage.getDriver().getTitle(), containsString("Стиральные машины"));

        return this;
    }


    public PriceFilterSteps verifyMinMaxFilter()
    {

        catalog.setFilter(MIN_PRICE_FILTER_12000);

        int minPriceBorder = Integer.parseInt(catalog.getDriver()
                .findElement(By.xpath(MIN_PRICE_FILTER_12000)).getText());

        Waiter.waitForElementPresentsByXpath(mainPage.getDriver(),
                MAX_PRICE_FILTER_18000);

        catalog.setFilter(MAX_PRICE_FILTER_18000);

        int maxPriceBorder = Integer.parseInt(catalog.getDriver()
                .findElement(By.xpath(MAX_PRICE_FILTER_18000)).getText());

        int actualMinPrice = Integer.parseInt(catalog.getDriver()
                .findElement(By.xpath(FIRST_PRODUCT_PRICE)).getText()
                .replace(" ", "").replace("грн", ""));

        WebElement lastPage = catalog.getDriver().findElement(
                By.xpath(LAST_SEARCH_PAGE));

        lastPage.click();

        int actualMaxPrice = Integer.parseInt(catalog.getDriver()
                .findElement(By.xpath(LAST_PRODUCT_PRICE)).getText()
                .replace(" ", "").replace("грн", ""));

        assertThat(minPriceBorder, (lessThanOrEqualTo(actualMinPrice)));

        assertThat(actualMaxPrice, lessThanOrEqualTo(maxPriceBorder));

        return this;

    }
}
