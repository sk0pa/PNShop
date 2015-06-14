package com.epam.tal5.khalii.pncom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalog extends AbstractPage {

    public static final String PRICE_SORT_LINK = "//div[@class='order']//a[contains(text(), 'цена')]";
    public static final String NAME_SORT_LINK = "//div[@class='order']//a[contains(text(), 'название')]";
    public static final String MAIN_PAGE_LINK = "//div[@id='page-breadcrumbs']//a[contains(text(), 'Главная')]";
    public static final String LINK_TO_COMPARE = "//div[@class='compareLine ']/a";

    @FindBy(xpath = PRICE_SORT_LINK)
    private WebElement priceSortLink;

    @FindBy(xpath = NAME_SORT_LINK)
    private WebElement productNameSortLink;

    @FindBy(xpath = MAIN_PAGE_LINK)
    private WebElement mainPageLink;

    @FindBy(xpath = LINK_TO_COMPARE)
    private WebElement comparsionLink;

    public ProductCatalog(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ProductInfoPage productItem(String xpath)
    {
        driver.findElement(By.xpath(xpath)).click();
        return new ProductInfoPage(driver);
    }

    public MainPage navigateToMainPage()
    {
        mainPageLink.click();
        return new MainPage(driver);
    }

    public ProductCatalog sortPrice()
    {
        priceSortLink.click();
        return this;
    }

    public ProductCatalog sortProductName()
    {
        productNameSortLink.click();
        return this;
    }

    public ProductComparePage navigateToComparePage()
    {
        comparsionLink.click();
        return new ProductComparePage(driver);
    }


    public ProductCatalog setFilter(String FilterXPath)
    {
        driver.findElement(By.xpath(FilterXPath)).click();
        return this;
    }
}
