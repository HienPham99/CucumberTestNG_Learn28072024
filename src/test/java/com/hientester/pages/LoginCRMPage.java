package com.hientester.pages;

import static hientester.com.keywords.WebUI.*;
import org.openqa.selenium.By;

public class LoginCRMPage {

    //Khai báo các Objects
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword= By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By messageError = By.xpath("//span[@data-notify='message']");

    //Hàm xử lý đặc trưng cho Login page
    public void enterEmailAndPassword(String email, String password){
        setText(inputEmail,email);
        setText(inputPassword,password);
    }

    public void clickLoginButton(){
        clickElement(buttonLogin);
    }
}
