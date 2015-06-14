package com.epam.tal5.khalii.pncom.tests;

import com.epam.tal5.khalii.pncom.steps.WeightFilterSteps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WeightFilterTest extends TestSettings {
    WeightFilterSteps weightFilter;

    @BeforeClass
    public void beforeClass()
    {
        weightFilter = new WeightFilterSteps(driver);
    }

    @Test
    public void comparsionOfProductsTest()
    {
        weightFilter.navigateToBreadmakerCatalog().selectWeightFilter().verifyWeightFilter();
    }

    @AfterClass
    public void afterClass()
    {
        weightFilter = null;
    }
}
