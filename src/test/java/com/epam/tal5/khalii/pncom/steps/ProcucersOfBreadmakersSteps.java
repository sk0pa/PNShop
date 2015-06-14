package com.epam.tal5.khalii.pncom.steps;

import com.epam.tal5.khalii.pncom.pages.MainPage;
import com.epam.tal5.khalii.pncom.pages.ProductCatalog;
import com.epam.tal5.khalii.pncom.tests.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class ProcucersOfBreadmakersSteps {
    ProductCatalog catalog;
    MainPage mainPage;
    HashSet<String> productManufacturerList;
    HashSet<String> productNameList ;


    public static final String MANUFACTURER_FILTER_BINATONE = "//a[contains(text(),'Binatone')]";
    public static final String MANUFACTURER_FILTER_LG = "//a[contains(text(),'Moulinex')]";
    public static final String MANUFACTURER_FILTER_SCARLER = "//a[contains(text(),'Vitek')]";
    public static final String PRODUCT_NAME_LIST = "//div[@class='item']/div[@class='name']/a";
    public static final String TITLE = "//div[@id='page-subheader']";


    public ProcucersOfBreadmakersSteps(WebDriver driver)
    {
        catalog = new ProductCatalog(driver);
        mainPage = new MainPage(driver);
    }


    public ProcucersOfBreadmakersSteps navigateToBreadmakerCatalog()
    {

        mainPage.navigateTo("http://pn.com.ua/");

        assertThat(mainPage.getDriver().getTitle(), containsString("Прайс навигатор"));

        catalog = mainPage.breadmakerCategory();

        Waiter.waitForElementPresentsByXpath(mainPage.getDriver(), TITLE);

        assertThat(mainPage.getDriver().getTitle(), containsString("Хлебопечи"));

        return this;
    }


    public ProcucersOfBreadmakersSteps selectManufacturerFilters()
    {
        productManufacturerList = new HashSet<String>();

        WebElement filterBimatone = catalog.getDriver().findElement(
                By.xpath(MANUFACTURER_FILTER_BINATONE));

        productManufacturerList.add(filterBimatone.getText());

        filterBimatone.click();


        WebElement filterLg = catalog.getDriver().findElement(
                By.xpath(MANUFACTURER_FILTER_LG));

        productManufacturerList.add(filterLg.getText());

        filterLg.click();

        WebElement filterScarler = catalog.getDriver().findElement(
                By.xpath(MANUFACTURER_FILTER_SCARLER));

        productManufacturerList.add(filterScarler.getText());

        filterScarler.click();

        return this;
    }

    public ProcucersOfBreadmakersSteps verifyThatSelectedManufacturerPresent()
    {

        List<WebElement> webPoductNameList = catalog.getDriver().findElements(
                By.xpath(PRODUCT_NAME_LIST));

        productNameList = new HashSet<String>();

        for (WebElement element : webPoductNameList)
        {
            productNameList.add((element.getText().split("\\s+"))[0]);
        }

        assertThat(productManufacturerList, is(productNameList));

        return this;
    }
}
