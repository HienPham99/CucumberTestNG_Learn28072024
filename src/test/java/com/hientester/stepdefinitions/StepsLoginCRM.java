package com.hientester.stepdefinitions;

import com.hientester.common.BaseTest;
import hientester.com.constants.ConstantGlobal;
import hientester.com.drivers.DriverManager;

import static hientester.com.keywords.WebUI.*;

import hientester.com.helpers.CaptureHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class StepsLoginCRM {

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        opeURL(ConstantGlobal.URL);
    }

    @When("I enter my username and password")
    public void iEnterMyUsernameAndPassword() {
        setText(By.xpath("//input[@id='email']"), ConstantGlobal.USERNAME);
        setText(By.xpath("//input[@id='password']"), ConstantGlobal.PASSWORD);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
       clickElement(By.xpath("//button[normalize-space()='Login']"));
    }

    @Then("I should be taken to the Dashboard page")
    public void iShouldBeTakenToTheDashboardPage() {
        CaptureHelper.takeScreenshot("Dashboard page");
    }

    @And("I should see the {string} menu")
    public void iShouldSeeTheMenu(String arg0) {
        Assert.assertEquals(arg0, "Project", "Menu name NOT match.");
    }
}
