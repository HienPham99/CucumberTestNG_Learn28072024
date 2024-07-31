package com.hientester.pages;

import com.hientester.common.BaseTest;
import hientester.com.constants.ConstantGlobal;
import hientester.com.helpers.PropertiesHelper;
import org.openqa.selenium.By;

import static hientester.com.keywords.WebUI.*;

public class LoginCMSPage {

    static {
        PropertiesHelper.loadAllFiles();
    }

    //Khai báo các Objects
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword= By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By messageError = By.xpath("//span[@data-notify='message']");//span[@data-notify='message']

    //Hàm xử lý đặc trưng cho Login page
    public void enterEmailAndPassword(String email, String password){
        setText(inputEmail,email);
        setText(inputPassword,password);
    }

    public void clickLoginButton(){
        clickElement(buttonLogin);
    }

    public CommonPage loginAdminRole(){
        BaseTest.createBrowser();
        opeURL(PropertiesHelper.getValue("URL"));
        setText(inputEmail, PropertiesHelper.getValue("USERNAME"));
        setText(inputPassword,PropertiesHelper.getValue("PASSWORD"));
        clickLoginButton();
        return new CommonPage();

    }

    public CommonPage loginProjectRole(){
        opeURL(PropertiesHelper.getValue("URL"));
        setText(inputEmail, PropertiesHelper.getValue("USERNAME"));
        setText(inputPassword,PropertiesHelper.getValue("PASSWORD"));
        clickLoginButton();
        return new CommonPage();
    }
}
