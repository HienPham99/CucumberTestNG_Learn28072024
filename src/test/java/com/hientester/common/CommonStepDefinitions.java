package com.hientester.common;

import com.hientester.hooks.TestContext;
import com.hientester.pages.CategoryPage;
import com.hientester.pages.CommonPage;
import com.hientester.pages.LoginCMSPage;
import com.hientester.pages.LoginCRMPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CommonStepDefinitions {

    TestContext testContext;
    LoginCRMPage loginCRMPage;
    LoginCMSPage loginCMSPage;
    CategoryPage categoryPage;
    CommonPage commonPage;

    public CommonStepDefinitions(TestContext testContext){
        this.testContext = testContext;
        commonPage = testContext.getCommonPage();
        loginCMSPage = testContext.getLoginCMSPage();
    }

    @Given("user logged in the CMS system with {string} role")
    public void userLoggedInTheCMSSystemWithRole(String roleName){
        loginCMSPage.loginAdminRole();
    }


    @And("User should see the notification displays")
    public void userShouldSeeTheNotificationDisplays() {

    }

    @Then("The message {string} displays")
    public void theMessageDisplays(String message) {
        Assert.assertEquals(commonPage.getMessageNotify(),message,"Message NOT match.");
    }
}
