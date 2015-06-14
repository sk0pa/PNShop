package com.epam.tal5.khalii.pncom.steps;

import com.epam.tal5.khalii.pncom.pages.MainPage;
import com.epam.tal5.khalii.pncom.pages.ProductCatalog;
import com.epam.tal5.khalii.pncom.pages.ProductInfoPage;
import com.epam.tal5.khalii.pncom.tests.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CompareShortAndFullDescriptionsSteps {
    ProductCatalog catalog;
    MainPage mainPage;
    ProductInfoPage infoPage;

    public static final String TITLE = "//div[@id='page-subheader']";

    public static final String PRODUCT_VALUE = "//div[contains(@class,'panel')]/div[@class='row'][position()<5]/span[@class='val']";


    public CompareShortAndFullDescriptionsSteps(WebDriver driver)
    {
        catalog = new ProductCatalog(driver);

        mainPage = new MainPage(driver);
    }


    public CompareShortAndFullDescriptionsSteps navigateToConditionerCatalog()
    {

        mainPage.navigateTo("http://pn.com.ua/");

        assertThat(mainPage.getDriver().getTitle(), containsString("Прайс навигатор"));

        catalog = mainPage.conditionerCategory();

        Waiter.waitForElementPresentsByXpath(mainPage.getDriver(), TITLE);

        assertThat(mainPage.getDriver().getTitle(), containsString("Кондиционер"));

        return this;
    }


    public CompareShortAndFullDescriptionsSteps compareShortAndFullDescriptions()
    {
        ArrayList<String> shortDescriptionList;

        ArrayList<String> fullDescriptionList;

        fullDescriptionList = new ArrayList<String>();

        List<WebElement> webPoductDescriptionList;

        List<WebElement> webPoductValueList;


        for (int i=1; i < 6; i++)
        {
            infoPage = catalog.productItem("//*[@class='item'][" + i + "]//div[@class='name']/a");


            webPoductValueList = infoPage.getDriver().findElements(
                    By.xpath(PRODUCT_VALUE));

            for (WebElement pr : webPoductValueList)
            {
                fullDescriptionList.add(pr.getText());
            }

            catalog = infoPage.navigateToCatalogPage();


            webPoductDescriptionList = catalog.getDriver().findElements(
                    By.xpath(".//*[@class='item'][" + i + "]//div[@class='description']"));

            shortDescriptionList = new ArrayList<String>();

            for (WebElement webCharacteristic : webPoductDescriptionList)
            {
                shortDescriptionList.addAll(Arrays.asList(webCharacteristic.getText().split(";")));
            }


            for (int j = 0; j < fullDescriptionList.size(); j++)
            {
                assertThat(shortDescriptionList.get(j), containsString(fullDescriptionList.get(j)));
            }

            shortDescriptionList.clear();

            fullDescriptionList.clear();
        }

        return this;
    }
}
