package com.epam.tal5.khalii.pncom.tests;

import com.epam.tal5.khalii.pncom.steps.PriceFilterSteps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PriceFilterTest extends TestSettings {
    PriceFilterSteps priceFilterSteps;

    @BeforeClass
    public void beforeClass()
    {
        priceFilterSteps = new PriceFilterSteps(driver);
    }

    @Test
    public void CompareOfProductsTest()
    {
        priceFilterSteps.navigateToWasherCatalog().verifyMinMaxFilter();
    }

    @AfterClass
    public void afterClass()
    {
        priceFilterSteps = null;
    }
}
