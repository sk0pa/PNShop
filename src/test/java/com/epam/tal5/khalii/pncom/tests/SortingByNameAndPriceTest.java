package com.epam.tal5.khalii.pncom.tests;

import com.epam.tal5.khalii.pncom.steps.SortingByNameAndPriceSteps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SortingByNameAndPriceTest extends TestSettings {

    SortingByNameAndPriceSteps sortSteps;

    @BeforeClass
    public void beforeClass()
    {
        sortSteps = new SortingByNameAndPriceSteps(driver);
    }

    @Test
    public void SortFridgeByPriceAndNameTest()
    {
        sortSteps.navigateToFridgeCatalog().sortFridgeByPrice()
                .sortFridgeByName().backToMain();
    }

    @AfterClass
    public void afterClass()
    {
        sortSteps = null;
    }
}
