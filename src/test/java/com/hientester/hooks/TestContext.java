package com.hientester.hooks;

import com.hientester.pages.CategoryPage;
import com.hientester.pages.CommonPage;
import com.hientester.pages.LoginCMSPage;
import com.hientester.pages.LoginCRMPage;
import hientester.com.drivers.DriverFactory;
import hientester.com.drivers.DriverManager;
import hientester.com.utils.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {

    private WebDriver driver;
    private CommonPage commonPage;
    private LoginCRMPage loginCRMPage;
    private LoginCMSPage loginCMSPage;
    private CategoryPage categoryPage;

    public TestContext(){
        ThreadGuard.protect(new DriverFactory().createDriver());
        LogUtils.info("Driver in TestContext: " + getDriver());
    }

    public CommonPage getCommonPage(){
        if (commonPage==null){
            commonPage=new CommonPage();
        }
        return commonPage;
    }

    public LoginCMSPage getLoginCMSPage(){
        if (loginCMSPage==null){
            loginCMSPage=new LoginCMSPage();
        }
        return loginCMSPage;
    }

    public LoginCRMPage getLoginCRMPage(){
        if (loginCRMPage==null){
            loginCRMPage=new LoginCRMPage();
        }
        return loginCRMPage;
    }

    public CategoryPage getCategoryPage(){
        if (categoryPage==null){
            categoryPage=new CategoryPage();
        }
        return categoryPage;
    }

    public WebDriver getDriver(){
        return DriverManager.getDriver();
    }

}
