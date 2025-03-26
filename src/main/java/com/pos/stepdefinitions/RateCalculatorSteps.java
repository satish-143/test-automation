// src/main/java/com/pos/stepdefinitions/RateCalculatorSteps.java
package com.pos.stepdefinitions;

import com.pos.pages.RateCalculatorPage;
import com.pos.utilities.TestContext;
import io.cucumber.java.en.*;

import static org.testng.Assert.assertTrue;

public class RateCalculatorSteps {

    private final TestContext testContext;
    private final RateCalculatorPage rateCalculatorPage;

    public RateCalculatorSteps(TestContext testContext) {
        this.testContext = testContext;
        this.rateCalculatorPage = testContext.getPageObjectManager().getRateCalculatorPage();
    }

    @Given("I navigate to the rate calculator page")
    public void i_navigate_to_the_rate_calculator_page() {
        rateCalculatorPage.navigateToRateCalculator();
    }

    @When("I enter From postcode {string}")
    public void i_enter_as_from_country_with_postcode(String postcode) {
        rateCalculatorPage.enterFromPostcode(postcode);
    }

    @When("I enter {string} as To country")
    public void i_enter_as_to_country(String country) {
        rateCalculatorPage.selectToCountry(country);
    }

    @And("I enter To postcode {string}")
    public void i_enter_as_to_country_with_postcode(String postcode) {
        rateCalculatorPage.enterToPostcode(postcode);
    }

    @When("I enter weight as {string} kg")
    public void i_enter_weight_as_kg(String weight) {
        rateCalculatorPage.enterWeight(weight);
    }

    @When("I click Calculate button")
    public void i_click_calculate_button() {
        rateCalculatorPage.clickCalculate();
    }

    @Then("I should see multiple shipping quotes available")
    public void i_should_see_multiple_shipping_quotes_available() {
        assertTrue(rateCalculatorPage.getQuoteCount() > 1,
                "Expected multiple quotes but found " + rateCalculatorPage.getQuoteCount());
    }
}