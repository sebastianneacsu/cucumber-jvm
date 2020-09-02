package com.automation.example.stepdefs;

import com.automation.example.pages.GooglePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSearchSteps {

    private RootSteps rootSteps;

    public GoogleSearchSteps(RootSteps rootSteps) {
        this.rootSteps = rootSteps;
    }


    @Given("^a web browser is on the Google page$")
    public void aWebBrowserIsOnTheGooglePage() throws Throwable {
        rootSteps.googlePage.navigateToHomePage();
    }

    @When("^the search phrase \"([^\"]*)\" is entered$")
    public void theSearchPhraseIsEntered(String phrase) throws Throwable {
        rootSteps.googlePage.enterSearchPhrase(phrase);
    }

    @Then("^results for \"([^\"]*)\" are shown$")
    public void resultsForAreShown(String phrase) throws Throwable {
        assertThat(rootSteps.googlePage.pageTitleContains(phrase)).isTrue();
    }
}
