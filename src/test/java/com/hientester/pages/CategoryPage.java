package com.hientester.pages;

import static hientester.com.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class CategoryPage {

    private By buttonAddNewCategory = By.xpath("//span[normalize-space()='Add New category']");
    private By inputCategoryName = By.xpath("//input[@id='name']");
    private By inputOrderingNumber = By.xpath("//input[@id='order_level']");
    private By inputMetaTitle = By.xpath("//input[@placeholder='Meta Title']");
    private By textareaMetaDescription = By.xpath("//textarea[@name='meta_description']");

    private By buttonSave = By.xpath("//button[normalize-space()='Save']");
    private By inputSearch = By.xpath("//input[@id='search']");

    public void clickAddNewButton(){
        clickElement(buttonAddNewCategory);
    }

    public void searchCategory(String categoryName){
        setTextAndKey(inputSearch,categoryName, Keys.ENTER);
    }

    public void inputDataCategory(String categoryName, String orderNumber, String metaTitle, String description) {
        waitForPageLoaded();
        setText(inputCategoryName, categoryName);
        setText(inputOrderingNumber, orderNumber);
        setText(inputMetaTitle, metaTitle);
        setText(textareaMetaDescription, description);
    }

    public void clickSaveButton(){
        clickElement(buttonSave);
    }



}
