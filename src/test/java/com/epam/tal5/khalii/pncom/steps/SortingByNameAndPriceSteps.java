package com.epam.tal5.khalii.pncom.steps;

import com.epam.tal5.khalii.pncom.pages.MainPage;
import com.epam.tal5.khalii.pncom.pages.ProductCatalog;
import com.epam.tal5.khalii.pncom.tests.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertTrue;

public class SortingByNameAndPriceSteps {
    MainPage mainPage;
    ProductCatalog catalog;

    public static final String ITEMS_PRICE_LIST = "//div[@class='catalog']/div[@class='item']/div[@class='price']/strong";
    public static final String ITEMS_NAME_LIST = "//div[@class='catalog']/div[@class='item']/div[@class='name']/strong";
    public static final String TITLE = "//div[@id='page-subheader']";
    public static final String MAIN_SEARCH_FILED = "//input[@id='edit-name-1']";


    public SortingByNameAndPriceSteps(WebDriver driver)
    {
        mainPage = new MainPage(driver);
    }

    public SortingByNameAndPriceSteps navigateToFridgeCatalog()
    {

        mainPage.navigateTo("http://pn.com.ua/");

        assertThat(mainPage.getDriver().getTitle(), containsString("Прайс навигатор"));

        catalog = mainPage.fridgeCategory();

        Waiter.waitForElementPresentsByXpath(mainPage.getDriver(), TITLE);

        assertThat(mainPage.getDriver().getTitle(), containsString("Холодильники"));

        return this;
    }

    public SortingByNameAndPriceSteps sortFridgeByPrice()
    {
        catalog.sortPrice();

        List<Integer> fridgePriceList = new ArrayList<Integer>();

        List<Integer> unsortedList = new ArrayList<Integer>();

        List<WebElement> webElementList = catalog.getDriver()
                .findElements(By.xpath(ITEMS_PRICE_LIST));

        for (WebElement fridgePrice : webElementList)
        {

            fridgePriceList.add(Integer.parseInt(fridgePrice.getText().replace(" ", "").replace("грн", "")));

        }
        unsortedList.addAll(fridgePriceList);

        Collections.sort(fridgePriceList);

        assertTrue(unsortedList.equals(fridgePriceList));

        return this;
    }

    public SortingByNameAndPriceSteps sortFridgeByName()
    {

        catalog.sortProductName();

        List<String> fridgeNameList = new ArrayList<String>();

        List<Object> unsortedList = new ArrayList<Object>();

        List<WebElement> webElementList = catalog.getDriver()
                .findElements(By.xpath(ITEMS_NAME_LIST));

        for (WebElement fridgeName : webElementList)
        {
            fridgeNameList.add(fridgeName.getText());
        }

        unsortedList.addAll(fridgeNameList);

        Collections.sort(fridgeNameList);

        assertTrue(unsortedList.equals(fridgeNameList));

        return this;
    }

    public SortingByNameAndPriceSteps backToMain()
    {
        catalog.navigateToMainPage();

        assertThat(mainPage.getDriver().getTitle(), containsString("Прайс навигатор"));

        Waiter.waitForElementPresentsByXpath(mainPage.getDriver(), MAIN_SEARCH_FILED);

        return this;
    }
}
