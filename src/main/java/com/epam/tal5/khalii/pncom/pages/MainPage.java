package com.epam.tal5.khalii.pncom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    public static final String FRIDGE_LINK = "//a[contains(text(), 'Холодильники')]";
    public static final String BREADMAKER_LINK = "//a[contains(text(), 'Хлебопечи')]";
    public static final String CONDITIONER_LINK = "//a[contains(text(), 'Кондиционеры')]";
    public static final String MICROWAVE_LINK = "//a[contains(text(), 'Микроволновки')]";
    public static final String WASHER_LINK = "//a[contains(text(), 'Стиральные машины')]";

    @FindBy(xpath = FRIDGE_LINK)
    private WebElement fridgeLink;

    @FindBy(xpath = MICROWAVE_LINK)
    private WebElement microwaveLink;


    @FindBy(xpath = BREADMAKER_LINK)
    private WebElement breadmakerLink;

    @FindBy(xpath = CONDITIONER_LINK)
    private WebElement conditionerLink;

    @FindBy(xpath = WASHER_LINK)
    private WebElement washerLink;


    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ProductCatalog fridgeCategory()
    {
        fridgeLink.click();
        return new ProductCatalog(driver);
    }

    public ProductCatalog washerCategory()
    {
        washerLink.click();
        return new ProductCatalog(driver);
    }

    public ProductCatalog microwaveCategory()
    {
        microwaveLink.click();
        return new ProductCatalog(driver);
    }

    public ProductCatalog breadmakerCategory()
    {
        breadmakerLink.click();
        return new ProductCatalog(driver);
    }

    public ProductCatalog conditionerCategory()
    {
        conditionerLink.click();
        return new ProductCatalog(driver);
    }
}
