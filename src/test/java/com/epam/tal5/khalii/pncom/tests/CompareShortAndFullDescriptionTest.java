package com.epam.tal5.khalii.pncom.tests;

import com.epam.tal5.khalii.pncom.steps.CompareShortAndFullDescriptionsSteps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CompareShortAndFullDescriptionTest extends TestSettings {
    CompareShortAndFullDescriptionsSteps assertDescriptionSteps;

    @BeforeClass
    public void beforeClass() {
        assertDescriptionSteps = new CompareShortAndFullDescriptionsSteps(driver);
    }

    @Test
    public void comparsionOfProductsTest() {
        assertDescriptionSteps.navigateToConditionerCatalog().compareShortAndFullDescriptions();
    }

    @AfterClass
    public void afterClass() {
        assertDescriptionSteps = null;
    }
}
