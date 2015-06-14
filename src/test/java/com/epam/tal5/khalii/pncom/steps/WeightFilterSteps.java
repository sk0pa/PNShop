package com.epam.tal5.khalii.pncom.steps;

import com.epam.tal5.khalii.pncom.pages.MainPage;
import com.epam.tal5.khalii.pncom.pages.ProductCatalog;
import com.epam.tal5.khalii.pncom.tests.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class WeightFilterSteps {
    ProductCatalog catalog;
    MainPage mainPage;
    List<String> productDescriptionList ;
    String FilterValue;


    public static final String WEIGHT_FILTER= "//a[contains(text(), 'Регулировка веса')]";
    public static final String PRODUCT_DESCRIPTION_LIST = "//div[@class='item']//div[@class='description']";
    public static final String TITLE = "//div[@id='page-subheader']";


    public WeightFilterSteps(WebDriver driver)
    {
        catalog = new ProductCatalog(driver);
        mainPage = new MainPage(driver);
    }


    public WeightFilterSteps navigateToBreadmakerCatalog()
    {

        mainPage.navigateTo("http://pn.com.ua/");

        assertThat(mainPage.getDriver().getTitle(), containsString("Прайс навигатор"));

        catalog = mainPage.breadmakerCategory();

        Waiter.waitForElementPresentsByXpath(mainPage.getDriver(), TITLE);

        assertThat(mainPage.getDriver().getTitle(), containsString("Хлебопечи"));

        return this;
    }


    public WeightFilterSteps selectWeightFilter()
    {

        WebElement WeightRegulationfilter = catalog.getDriver().findElement(
                By.xpath(WEIGHT_FILTER));

        FilterValue=WeightRegulationfilter.getText();

        WeightRegulationfilter.click();

        return this;
    }

    public WeightFilterSteps verifyWeightFilter()
    {

        List<WebElement> webPoductDescriptionList = catalog.getDriver().findElements(
                By.xpath(PRODUCT_DESCRIPTION_LIST));

        productDescriptionList = new ArrayList<String>();

        for (WebElement description : webPoductDescriptionList)
        {
            assertThat(description.getText(),containsString(FilterValue));
        }

        return this;
    }
}

