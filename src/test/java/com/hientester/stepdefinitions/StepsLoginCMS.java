package com.hientester.stepdefinitions;

import com.hientester.common.BaseTest;
import com.hientester.hooks.TestContext;
import com.hientester.pages.LoginCMSPage;
import hientester.com.drivers.DriverManager;
import hientester.com.helpers.ExcelHelper;
import hientester.com.helpers.PropertiesHelper;
import hientester.com.keywords.WebUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class StepsLoginCMS {

    LoginCMSPage loginCMSPage;
    ExcelHelper excelHelper;

    public StepsLoginCMS(TestContext testContext) {
        loginCMSPage = testContext.getLoginCMSPage();
    }

    @Given("User navigate to login page {string}")
    public void userNavigateToLoginPage(String URL) {
        BaseTest.createBrowser();
        WebUI.opeURL(URL);

    }

    @When("User enter email {string} and password {string}")
    public void userEnterEmailAndPassword(String email, String password) {
        loginCMSPage.enterEmailAndPassword(email, password);
    }

    @And("click login button")
    public void clickLoginButton() {
        loginCMSPage.clickLoginButton();
    }

    @Then("User redirect to admin page {string}")
    public void userRedirectToAdminPage(String url) {
        WebUI.assertEquals(url, DriverManager.getDriver().getCurrentUrl(), "URL chuyển hướng không đúng");
        BaseTest.closeDriver();
    }

    @Given("the user is on the login page")
    public void userIsOnTheLoginPage() {
        loginCMSPage.goToLoginPage();
//        WebUI.opeURL(PropertiesHelper.getValue("URl"));
//        WebUI.checkElementExist(By.xpath("//p[normalize-space()='Login to your account.']"));
    }

    @When("the user enters valid username and password")
    public void theUserEntersValidUsernameAndPassword() {
        excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/datatest/CMS.xlsx", "Login");
        loginCMSPage.enterEmailAndPassword(excelHelper.getCellData("email", 1),
                excelHelper.getCellData("password", 1));
    }


    @And("clicks the login button")
    public void clicksTheLoginButton() {
        loginCMSPage.clickLoginButton();
    }

    @Then("the user should be redirected to the admin page")
    public void theUserShouldBeRedirectedToTheAdminPage() {
        loginCMSPage.verifyRedirectToAdminPage();
    }

    @When("the user enters an invalid username or password")
    public void theUserEntersAnInvalidUsernameOrPassword() {
        excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/datatest/CMS.xlsx", "Login");
        loginCMSPage.enterEmailAndPassword(excelHelper.getCellData("email", 2),
                excelHelper.getCellData("password", 2));
    }

    @Then("the user should see an error message")
    public void theUserShouldSeeAnErrorMessage() {

    }

    @And("stay on the login page")
    public void stayOnTheLoginPage() {
    }

    @Given("the user on the login page")
    public void theUserOnTheLoginPage() {
    }

    @When("the user leaves the username fields empty")
    public void theUserLeavesTheUsernameFieldsEmpty() {
    }

    @When("the user leaves the password fields empty")
    public void theUserLeavesThePasswordFieldsEmpty() {
    }

    @And("my account has been locked")
    public void myAccountHasBeenLocked() {
    }

    @When("user enter valid username and password")
    public void userEnterValidUsernameAndPassword() {
    }

    @And("the user have forgotten my password")
    public void theUserHaveForgottenMyPassword() {
    }

    @When("user click on the {string} link")
    public void userClickOnTheLink(String arg0) {
    }

    @And("enter my email address")
    public void enterMyEmailAddress() {
    }

    @And("click on the {string} button")
    public void clickOnTheButton(String arg0) {
    }

    @Then("the user should receive an email with instructions to reset my password.")
    public void theUserShouldReceiveAnEmailWithInstructionsToResetMyPassword() {
    }
}
