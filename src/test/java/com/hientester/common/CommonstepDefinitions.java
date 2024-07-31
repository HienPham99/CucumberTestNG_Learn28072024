package com.hientester.common;

import com.hientester.pages.CategoryPage;
import com.hientester.pages.CommonPage;
import com.hientester.pages.LoginCMSPage;
import com.hientester.pages.LoginCRMPage;
import hientester.com.keywords.WebUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CommonstepDefinitions {

    //TestContext testContext;
    LoginCRMPage loginCRMPage;
    LoginCMSPage loginCMSPage;
    CategoryPage categoryPage;
    CommonPage commonPage;

    @Given("user logged in the CMS system with {string} role")
    public void userLoggedInTheCMSSystemWithRole(String role){
        loginCMSPage.loginAdminRole();
    }

    @Then("the message {string} displays")
    public void theMessageDisplays(String message){
       // Assert.assertEquals(commonPage.getMessageNotify(),message,"Message NOT match.");

    }

    @And("User should see the notification displays")
    public void userShouldSeeTheNotificationDisplays() {
        BaseTest.closeDriver();
    }
}
