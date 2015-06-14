package com.epam.tal5.khalii.pncom.tests;

import com.epam.tal5.khalii.pncom.steps.ProcucersOfBreadmakersSteps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProducersOfBreadmakersTest extends TestSettings {

    ProcucersOfBreadmakersSteps breadmakersSteps;

    @BeforeClass
    public void beforeClass()
    {
        breadmakersSteps = new ProcucersOfBreadmakersSteps(driver);
    }

    @Test
    public void comparsionOfProductsTest()
    {
        breadmakersSteps.navigateToBreadmakerCatalog()
                .selectManufacturerFilters()
                .verifyThatSelectedManufacturerPresent();
    }

    @AfterClass
    public void afterClass()
    {
        breadmakersSteps = null;
    }
}

