package com.hientester.pages;

import static hientester.com.keywords.WebUI.*;
import org.openqa.selenium.By;

public class CommonPage {

    private By menuProducts = By.xpath("(//ul[@id='main-menu']/descendant::span)[2]");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");
    private By menuAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
    private By menuAllProducts = By.xpath("//span[normalize-space()='All products']");

    public void clickMenuProduct(){
        clickElement(menuProducts);

    }
    public CategoryPage openCategoriesPage(){
        clickElement(menuCategory);
        return new CategoryPage();
    }
//
//    public CategoryPage openAddNewProductPage(){
//        clickElement(menuAddNewProduct);
//        return new CategoryPage();
//    }

}
