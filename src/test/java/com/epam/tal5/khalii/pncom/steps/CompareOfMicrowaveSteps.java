package com.epam.tal5.khalii.pncom.steps;

import com.epam.tal5.khalii.pncom.pages.MainPage;
import com.epam.tal5.khalii.pncom.pages.ProductCatalog;
import com.epam.tal5.khalii.pncom.pages.ProductComparePage;
import com.epam.tal5.khalii.pncom.pages.ProductInfoPage;
import com.epam.tal5.khalii.pncom.tests.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CompareOfMicrowaveSteps {
    ProductCatalog catalog;
    MainPage mainPage;
    ProductComparePage comparePage;
    ProductInfoPage productInfo;

    public static final String LINK_PRODUCT_1_COMPARSION = ".//div[@class='item'][1]//*[@class='compare-links']//span";
    public static final String LINK_PRODUCT_2_COMPARSION = ".//div[@class='item'][2]//*[@class='compare-links']//span";
    public static final String LINK_PRODUCT_1_INFO = "//*[@class='row-2'][1]//a";
    public static final String LINK_PRODUCT_2_INFO = "//*[@class='row-2'][2]//a";
    public static final String PRODUCT_INFO_HEADER="//*[@id='page-subheader']/h1";
    public static final String PRODUCT_1_PARAMETERS = "//tbody//tr[not(@style)]//td[ not(@class) and not(.//div)][2]";
    public static final String PRODUCT_2_PARAMETERS = "//tbody//tr[not(@style)]//td[ not(@class) and not(.//div)][3]";

    public CompareOfMicrowaveSteps(WebDriver driver)
    {
        catalog = new ProductCatalog(driver);
        mainPage = new MainPage(driver);
    }

    public CompareOfMicrowaveSteps navigateToMicrowaveCatalog()
    {
        mainPage.navigateTo("http://pn.com.ua/");

        catalog = mainPage.microwaveCategory();

        assertThat(catalog.getDriver().getTitle(), containsString("Микроволновые печи"));

        return this;
    }

    public CompareOfMicrowaveSteps addProductToCompare()
    {
        WebElement product1 = catalog.getDriver().findElement(
                By.xpath(LINK_PRODUCT_1_COMPARSION));

        product1.click();

        WebElement product2 = catalog.getDriver().findElement(
                By.xpath(LINK_PRODUCT_2_COMPARSION));

        product2.click();

        comparePage = catalog.navigateToComparePage();

        assertThat(comparePage.getDriver().getTitle(),
                containsString("сравнение"));
        return this;
    }


    public CompareOfMicrowaveSteps assertThatAllParametersPresent()
    {
        Waiter.waitForElementPresentsByXpath(comparePage.getDriver(),
                LINK_PRODUCT_1_INFO);

        productInfo = comparePage.navigateToProduct(LINK_PRODUCT_1_INFO);

        Waiter.waitForElementPresentsByXpath(productInfo.getDriver(), PRODUCT_INFO_HEADER);

        List<String> paramFromInfo = productInfo.getProductParameters();

        comparePage = productInfo.navigateToComparePage();

		/* assertion for product 1 */

        List<WebElement> webParamFromComparison = catalog.getDriver()
                .findElements(By.xpath(PRODUCT_1_PARAMETERS));

        List<String> paramFromCompare = new ArrayList<String>();

        for (WebElement element : webParamFromComparison) {
            paramFromCompare.add(element.getText());
        }

        for (String p : paramFromInfo) {
            assertThat(paramFromCompare, hasItem(p));
        }

		/* assertion for product 2 */

        Waiter.waitForElementPresentsByXpath(comparePage.getDriver(),
                LINK_PRODUCT_2_INFO);

        productInfo = comparePage.navigateToProduct(LINK_PRODUCT_2_INFO);

        Waiter.waitForElementPresentsByXpath(productInfo.getDriver(),
                "//*[@id='page-subheader']/h1");

        paramFromInfo = productInfo.getProductParameters();

        comparePage = productInfo.navigateToComparePage();

        webParamFromComparison = comparePage.getDriver().findElements(
                By.xpath(PRODUCT_2_PARAMETERS));

        for (WebElement element : webParamFromComparison) {
            paramFromCompare.add(element.getText());
        }

        for (String p : paramFromInfo) {
            assertThat(paramFromCompare, hasItem(p));
        }
        return this;
    }

    public CompareOfMicrowaveSteps verifyDifferentParameterColour()
    {
        List<WebElement> webParamCompareProduct1 = comparePage.getDriver()
                .findElements(By.xpath(PRODUCT_1_PARAMETERS));

        List<WebElement> classNameList = comparePage.getDriver()
                .findElements(By.xpath(PRODUCT_1_PARAMETERS + "/.."));

        List<String> paramCompareProduct1 = new ArrayList<String>();

        for (WebElement element : webParamCompareProduct1)
        {
            paramCompareProduct1.add(element.getText());
        }

        List<WebElement> webParamCompareProduct2 = comparePage.getDriver()
                .findElements(By.xpath(PRODUCT_2_PARAMETERS));

        List<String> paramCompareProduct2 = new ArrayList<String>();

        for (WebElement element : webParamCompareProduct2)
        {
            paramCompareProduct2.add(element.getText());
        }

        for (int i = 0; i < paramCompareProduct2.size() - 1; i++)
        {

            if (!paramCompareProduct1.get(i).equalsIgnoreCase(
                    paramCompareProduct2.get(i)))
            {

                assertThat(classNameList.get(i).getAttribute("class"),
                        containsString("different"));
            }
        }
        return this;
    }
}
