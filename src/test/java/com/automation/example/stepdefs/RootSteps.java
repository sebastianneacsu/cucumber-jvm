package com.automation.example.stepdefs;

import com.automation.example.pages.GooglePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RootSteps{


    public WebDriver driver;
    public GooglePage googlePage;


    @Before(value = "@web", order = 1)
    public void initWebDriver() throws Throwable {
        driver = new ChromeDriver();
    }

    @Before(value = "@google", order = 10)
    public void initGooglePage() throws Throwable {
        googlePage = new GooglePage(driver);
    }

    @After(value = "@web")
    public void disposeWebDriver() throws Throwable {
        driver.quit();
    }
}