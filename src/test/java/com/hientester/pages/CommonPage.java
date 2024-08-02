package com.hientester.pages;

import static hientester.com.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class CommonPage {

    private By menuProducts = By.xpath("(//ul[@id='main-menu']/descendant::span)[2]");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");
    private By menuAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
    private By menuAllProducts = By.xpath("//span[normalize-space()='All products']");

    private By messageNotify = By.xpath("//span[@data-notify='message']");

    private By buttonEdit = By.xpath("(//a[@title='Edit'])[1]");
    private By inputSearch = By.xpath("//input[@id='search']");

    private By menuAll = By.xpath("//ul[@id='main-menu']");

    public void searchDataTable(String dataTable){
        setTextAndKey(inputSearch,dataTable, Keys.ENTER);
    }

    public void clickEditButton(){
        clickElement(buttonEdit);
    }

    public void verifyElementVisibled(){
        verifyElementVisible(menuAll, "Can not redirect to Admin page.");
    }

    public String getMessageNotify(){
        return getElementText(messageNotify);
    }

    public void clickMenuProduct(){
        clickElement(menuProducts);

    }
    public CategoryPage openCategoriesPage(){
        clickElement(menuCategory);
        return new CategoryPage();
    }

}
