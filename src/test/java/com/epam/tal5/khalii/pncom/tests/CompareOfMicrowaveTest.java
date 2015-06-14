package com.epam.tal5.khalii.pncom.tests;

import com.epam.tal5.khalii.pncom.steps.CompareOfMicrowaveSteps;
import com.epam.tal5.khalii.pncom.steps.SortingByNameAndPriceSteps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CompareOfMicrowaveTest extends TestSettings {
    SortingByNameAndPriceSteps sortSteps;
    CompareOfMicrowaveSteps compareSteps;

    @BeforeClass
    public void beforeClass()
    {
        compareSteps = new CompareOfMicrowaveSteps(driver);
    }

    @Test
    public void compareOfProductsTest()
    {
        compareSteps.navigateToMicrowaveCatalog().addProductToCompare()
                .assertThatAllParametersPresent()
                .verifyDifferentParameterColour();
    }

    @AfterClass
    public void afterClass()
    {
        compareSteps = null;
    }
}
