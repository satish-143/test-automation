// src/main/java/com/pos/pages/PageObjectManager.java
package com.pos.pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private RateCalculatorPage rateCalculatorPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public RateCalculatorPage getRateCalculatorPage() {
        return (rateCalculatorPage == null) ? rateCalculatorPage = new RateCalculatorPage(driver) : rateCalculatorPage;
    }
}