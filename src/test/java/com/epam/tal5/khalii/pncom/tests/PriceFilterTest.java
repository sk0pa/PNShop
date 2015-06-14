package com.epam.tal5.khalii.pncom.tests;

import com.epam.tal5.khalii.pncom.steps.PriceFilterSteps;
import com.epam.tal5.khalii.pncom.steps.SortingByNameAndPriceSteps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PriceFilterTest extends TestsSet {

    SortingByNameAndPriceSteps sortSteps;
    PriceFilterSteps verifyPriceFilterSteps;

    @BeforeClass
    public void beforeClass()
    {
        verifyPriceFilterSteps = new PriceFilterSteps(driver);
    }

    @Test
    public void ComparsionOfProductsTest()
    {
        verifyPriceFilterSteps.navigateToFridgeCatalog().verifyMinMaxFilter();
    }

    @AfterClass
    public void afterClass()
    {
        verifyPriceFilterSteps = null;
    }
}
