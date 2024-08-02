package com.hientester.pages;

import com.hientester.common.BaseTest;
import hientester.com.constants.ConstantGlobal;
import hientester.com.drivers.DriverManager;
import hientester.com.helpers.PropertiesHelper;
import org.openqa.selenium.By;
import org.testng.Assert;

import static hientester.com.keywords.WebUI.*;

public class LoginCMSPage extends CommonPage {

    private String URL = "https://cms.anhtester.com/login";
    //Khai báo các Objects
    private By headerLoginPage = By.xpath("//p[normalize-space()='Login to your account.']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By messageError = By.xpath("//span[@data-notify='message']");
    private By menuAll = By.xpath("//ul[@id='main-menu']");


    public void goToLoginPage() {
        opeURL(URL);
        //Xác nhận 1 cái element thuộc trang login được hiển thị
        verifyElementVisible(headerLoginPage);
    }

    public void verifyRedirectToAdminPage() {
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("admin"), "Login Unsuccess. Vẫn ở trang Login page.");
        verifyElementVisibled();
        //verifyElementVisible(menuAll);
    }

    public void verifyTheUserShouldSeeAnErrorMessage(){
        verifyElementVisible(messageError,"The Error message NOT visible.");
        assertEquals(getElementText(messageError),"Invalid login credentials","Content Error message NOT match.");

    }

    //Hàm xử lý đặc trưng cho Login page
    public void enterEmailAndPassword(String email, String password) {
        setText(inputEmail, email);
        setText(inputPassword, password);
    }

    public void clickLoginButton() {
        clickElement(buttonLogin);
    }

    public CommonPage loginAdminRole() {
        opeURL(PropertiesHelper.getValue("URL"));
        setText(inputEmail, PropertiesHelper.getValue("USERNAME"));
        setText(inputPassword, PropertiesHelper.getValue("PASSWORD"));
        clickLoginButton();
        return new CommonPage();

    }

    public CommonPage loginProjectRole() {
        opeURL(PropertiesHelper.getValue("URL"));
        setText(inputEmail, PropertiesHelper.getValue("USERNAME"));
        setText(inputPassword, PropertiesHelper.getValue("PASSWORD"));
        clickLoginButton();
        return new CommonPage();
    }
}
