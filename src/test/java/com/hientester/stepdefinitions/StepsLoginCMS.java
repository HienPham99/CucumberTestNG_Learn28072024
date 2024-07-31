package com.hientester.stepdefinitions;

import com.hientester.common.BaseTest;
import com.hientester.pages.LoginCMSPage;
import hientester.com.drivers.DriverManager;
import hientester.com.keywords.WebUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsLoginCMS {

    LoginCMSPage loginCMSPage;

    @Given("User navigate to login page {string}")
    public void userNavigateToLoginPage(String URL) {
        BaseTest.createBrowser();
        WebUI.opeURL(URL);

    }

    @When("User enter email {string} and password {string}")
    public void userEnterEmailAndPassword(String email, String password) {
       loginCMSPage=new LoginCMSPage();
        loginCMSPage.enterEmailAndPassword(email, password);
    }

    @And("click login button")
    public void clickLoginButton() {
        loginCMSPage.clickLoginButton();
    }

    @Then("User redirect to admin page {string}")
    public void userRedirectToAdminPage(String url) {
        WebUI.assertEquals(url,DriverManager.getDriver().getCurrentUrl(),"URL chuyển hướng không đúng");
        BaseTest.closeDriver();
    }

    }
