package com.epam.tal5.khalii.pncom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductComparePage extends AbstractPage {
    public static final String MAIN_PAGE_LINK = "//div[@id='page-breadcrumbs']//a[contains(text(), 'Главная')]";

    @FindBy(xpath = MAIN_PAGE_LINK)
    private WebElement mainPageLink;

    public ProductComparePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage navigateToMainPage()
    {
        mainPageLink.click();
        return new MainPage(driver);
    }

    public ProductInfoPage navigateToProduct(String xPathProduct)
    {
        driver.findElement(By.xpath(xPathProduct)).click();
        return new ProductInfoPage(driver);
    }
}
