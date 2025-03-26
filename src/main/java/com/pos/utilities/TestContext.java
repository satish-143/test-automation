// src/main/java/com/pos/utilities/TestContext.java
package com.pos.utilities;

import com.pos.pages.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestContext {
    private static WebDriver driver;
    private PageObjectManager pageObjectManager;

    public TestContext() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageObjectManager = new PageObjectManager(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public static void closeDriver() {
        driver.quit();
        // open a cucumber report

    }
}