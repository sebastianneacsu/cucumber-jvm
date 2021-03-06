package com.automation.example.stepdefs;

import com.automation.example.pages.GooglePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RootSteps{


    public WebDriver driver;
    public GooglePage googlePage;


    @Before(value = "@web", order = 1)
    public void initWebDriver() throws Throwable {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
    }

    @Before(value = "@google", order = 10)
    public void initGooglePage() throws Throwable {
        googlePage = new GooglePage(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.embed(screenshot, "image/png");
        }
    }
    @After(value = "@web")
    public void disposeWebDriver() throws Throwable {
        driver.quit();
    }
}