package com.hientester.stepdefinitions;

import com.hientester.common.BaseTest;
import com.hientester.pages.CommonPage;
import com.hientester.pages.LoginCMSPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepCategories {

    LoginCMSPage loginCMSPage;
    CommonPage commonPage;

    @Given("user logged in the CMS system with {string} role")
    public void userLoggedInTheCMSSystemWithRole(String arg0) {
        loginCMSPage = new LoginCMSPage();
        commonPage = loginCMSPage.loginAdminRole();
    }

    @Given("User has access to the Category page")
    public void userHasAccessToTheCategoryPage() {
        commonPage.clickMenuProduct();
        commonPage.openCategoriesPage();

    }

    @When("User has finished entering the category information")
    public void userHasFinishedEnteringTheCategoryInformation(DataTable dataTable) {
        //Đọc data từ file Excel
        //Or đọc data từ data table
    }

    @And("click the Save button")
    public void clickTheSaveButton() {
    }

    @Then("The message {string} successfully displays")
    public void theMessageSuccessfullyDisplays(String message) {

        BaseTest.closeDriver();
    }

}
