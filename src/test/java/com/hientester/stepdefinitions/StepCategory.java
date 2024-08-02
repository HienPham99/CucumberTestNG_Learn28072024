package com.hientester.stepdefinitions;

import com.hientester.common.BaseTest;
import com.hientester.hooks.TestContext;
import com.hientester.pages.CategoryPage;
import com.hientester.pages.CommonPage;
import com.hientester.pages.LoginCMSPage;
import hientester.com.helpers.ExcelHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepCategory {

    TestContext testContext;
    LoginCMSPage loginCMSPage;
    CategoryPage categoryPage;
    CommonPage commonPage;
    ExcelHelper excelHelper;

    public StepCategory(TestContext testContext) {
        this.testContext = testContext;
        commonPage = testContext.getCommonPage();
        loginCMSPage = testContext.getLoginCMSPage();
    }

    @Given("User has access to the Category page")
    public void userHasAccessToTheCategoryPage() {
        commonPage.clickMenuProduct();
        categoryPage = commonPage.openCategoriesPage();

    }

    @When("User has finished entering the category information")
    public void userHasFinishedEnteringTheCategoryInformation() {
        categoryPage.clickAddNewButton();
        excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/datatest/CMS.xlsx", "Category");
        categoryPage.inputDataCategory(
                excelHelper.getCellData("category_name", 1),
                excelHelper.getCellData("order_number", 1),
                excelHelper.getCellData("meta_title", 1),
                excelHelper.getCellData("description", 1)
        );

    }

    @And("click the Save button")
    public void clickTheSaveButton() {
        categoryPage.clickSaveButton();
    }

    @When("user search a category existing {string}")
    public void userSearchACategoryExisting(String categoryName) {
        categoryPage.searchCategory(categoryName);
    }

    @And("user edit the category information")
    public void userEditTheCategoryInformation() {
        commonPage.clickEditButton();
        excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/datatest/CMS.xlsx", "Category");
        categoryPage.inputDataCategory(
                excelHelper.getCellData("category_name", 1),
                excelHelper.getCellData("order_number", 1),
                excelHelper.getCellData("meta_title", 1),
                excelHelper.getCellData("description", 1)
        );
    }
}
