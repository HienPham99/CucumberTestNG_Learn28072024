package com.hientester.common;

import hientester.com.constants.ConstantGlobal;
import hientester.com.drivers.DriverManager;
import hientester.com.helpers.PropertiesHelper;
//import com.hientester.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

//@Listeners(TestListener.class)
public class BaseTest {

    //truyenf Browser động
    //@Parameters({"BROWSER"})
    public static void createBrowser(String browserName) {
        PropertiesHelper.loadAllFiles();
        WebDriver driver = setupBrowser(browserName);
        DriverManager.setDriver(driver);
    }

    //Truyền Browser Name Cứng là "chrome
    public static void createBrowser() {
        PropertiesHelper.loadAllFiles();
        WebDriver driver = setupBrowser("chrome");
        DriverManager.setDriver(driver);
    }

    //Viết hàm trung gian để lựa chọn Browser cần chạy với giá trị tham số "browser" bên trên truyền vào
    public static WebDriver setupBrowser(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

//    public static WebDriver setBrowser(String browserName) {
//        WebDriver driver = null;
//
//        if (browserName.trim().toLowerCase().equals("chrome")) {
//            driver = new ChromeDriver();
//        }
//        if (browserName.trim().toLowerCase().equals("edge")) {
//            driver = new EdgeDriver();
//        }
//        if (browserName.trim().toLowerCase().equals("firefox")) {
//            driver = new FirefoxDriver();
//        }
//
//        return driver;
//    }

    // Viết các hàm khởi chạy cho từng Browser đó
//    private static WebDriver initChromeDriver() {
//        WebDriver driver;
//        System.out.println("Launching Chrome browser...");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        return driver;
//    }
    // Viết các hàm khởi chạy cho từng Browser đó
    private static WebDriver initChromeDriver() {
        WebDriver driver;
        System.out.println("Launching Chrome browser...");

        ChromeOptions options = new ChromeOptions();
        if (ConstantGlobal.HEADLESS == true) {
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        } else {
            options.addArguments("--start-maximized");
        }

        driver = new ChromeDriver(options);

        return driver;
    }

    //    private static WebDriver initEdgeDriver() {
//        WebDriver driver;
//        System.out.println("Launching Edge browser...");
//        driver = new EdgeDriver();
//        driver.manage().window().maximize();
//        return driver;
//    }
    private static WebDriver initEdgeDriver() {
        WebDriver driver;
        System.out.println("Launching Edge browser...");

        EdgeOptions options = new EdgeOptions();

        if (ConstantGlobal.HEADLESS == true) {
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        } else {
            options.addArguments("--start-maximized");
        }

        driver = new EdgeDriver(options);

        return driver;
    }

    //    private static WebDriver initFirefoxDriver() {
//        WebDriver driver;
//        System.out.println("Launching Firefox browser...");
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        return driver;
//    }
    private static WebDriver initFirefoxDriver() {
        WebDriver driver;
        System.out.println("Launching Firefox browser...");

        FirefoxOptions options = new FirefoxOptions();
        if (ConstantGlobal.HEADLESS == true) {
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        }

        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }


    public static void closeDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }

}
