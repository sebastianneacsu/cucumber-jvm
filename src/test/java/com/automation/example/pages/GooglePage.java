package com.automation.example.pages;

import com.automation.example.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePage extends AbstractPage {

    @FindBy(name="q")
    private WebElement BY_SEARCH_FIELD;
    //private static final By BY_SEARCH_FIELD = By.name("q");

    public GooglePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void navigateToHomePage() {
        String baseUrl = this.getEnvProps().get("url");
        getDriver().navigate().to(baseUrl);
     }

    public void enterSearchPhrase(String phrase) {
        WebElement searchField = driverWait(10).until(ExpectedConditions.elementToBeClickable(BY_SEARCH_FIELD));
        searchField.sendKeys(phrase);
        searchField.submit();
    }

    public boolean pageTitleContains(String phrase) {
        try {
            return driverWait(5).until(ExpectedConditions.titleContains(phrase));
        } catch (TimeoutException ex) {
            return false;
        }
    }
}
