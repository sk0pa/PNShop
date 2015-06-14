package com.epam.tal5.khalii.pncom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoPage extends AbstractPage {
    public static final String PARAMETERS_LIST = "//span[@class='val']";
    public static final String LINK_TO_COMPARE = "//a[@class='head-compare-link']";
    public static final String LINK_TO_CATALOG = "//div[@id='page-breadcrumbs']/a[3]";

    public List<String> parametersList;

    @FindBy(xpath = PARAMETERS_LIST)
    private List<WebElement> parametersWebList;

    @FindBy(xpath = LINK_TO_COMPARE)
    private WebElement compareLink;

    @FindBy(xpath = LINK_TO_CATALOG)
    private WebElement catalogLink;

    public ProductInfoPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<String> getProductParameters()
    {
        parametersList = new ArrayList<String>();
        for (WebElement element : parametersWebList)
            parametersList.add(element.getText());
        return parametersList;
    }

    public ProductComparePage naivageToComaparsionPage()
    {
        compareLink.click();
        return new ProductComparePage(driver);
    }

    public ProductCatalog navigateToCatalogPage()
    {
        catalogLink.click();
        return new ProductCatalog(driver);
    }
}
