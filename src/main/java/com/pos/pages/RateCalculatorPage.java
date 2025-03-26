// src/main/java/com/pos/pages/RateCalculatorPage.java
package com.pos.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RateCalculatorPage extends BasePage {


    @FindBy(css = "[formcontrolname=postcodeFrom]")
    private WebElement fromPostcodeInput;

    @FindBy(id = "mat-input-0")
    private WebElement toCountryDropdown;

    @FindBy(css = "small[title=\'India - IN\']")
    private WebElement toCountryDropdownSuggestions;


    @FindBy(css = "[formcontrolname=postcodeTo]")
    private WebElement toPostcodeInput;

    @FindBy(css = "[formcontrolname=itemWeight]")
    private WebElement weightInput;

    @FindBy(css = "a[type=\' button\']")
    private WebElement calculateButton;

    @FindBy(xpath = "//div[@class='max-w-full border-b']/following-sibling::div")
    private List<WebElement> quoteItems;

    public RateCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToRateCalculator() {
        driver.get("https://pos.com.my/send/ratecalculator");
    }

    public void enterFromPostcode(String postcode) {
        fromPostcodeInput.sendKeys(postcode);
        // Wait for state to be populated if needed
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.attributeToBeNotEmpty(fromPostcodeInput, "value"));
    }

    public void selectToCountry(String country) {
        toCountryDropdown.clear();
        toCountryDropdown.sendKeys(country);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfAllElements(toCountryDropdownSuggestions));
        toCountryDropdownSuggestions.click();
    }

    public void enterToPostcode(String postcode) {
        toPostcodeInput.sendKeys(postcode);
    }

    public void enterWeight(String weight) {
        weightInput.clear();
        weightInput.sendKeys(weight);
    }

    public void clickCalculate() {
        calculateButton.click();
        // Wait for quotes to load
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfAllElements(quoteItems));
    }

    public int getQuoteCount() {
        return quoteItems.size();
    }
}