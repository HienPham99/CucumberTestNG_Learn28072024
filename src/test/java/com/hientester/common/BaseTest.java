package com.hientester.common;

import hientester.com.constants.ConstantGlobal;
import hientester.com.drivers.DriverManager;
import hientester.com.helpers.PropertiesHelper;
//import com.hientester.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

//@Listeners(TestListener.class)
public class BaseTest {

    //truyenf Browser động
    //@Parameters({"BROWSER"})
    public static void createBrowser(@Optional("chrome") String browserName) {
        PropertiesHelper.loadAllFiles();
        WebDriver driver = setupBrowser(ConstantGlobal.BROWSER);
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

    public static WebDriver setBrowser(String browserName) {
        WebDriver driver = null;

        if (browserName.trim().toLowerCase().equals("chrome")) {
            //***Set cho chạy chế độ ÂN DANH
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
//            driver = new ChromeDriver(options);
            //***Set chế độ ẨN DANH với file properties
            //***
//            ChromeOptions options = new ChromeOptions();
//            if (PropertiesHelper.getValue("HEADLESS").equals("true")) {
//                options.addArguments("--headless");
//            }
//            driver = new ChromeDriver(options);
            //***
            driver = new ChromeDriver();
        }
        if (browserName.trim().toLowerCase().equals("edge")) {
            driver = new EdgeDriver();
        }
        if (browserName.trim().toLowerCase().equals("firefox")) {
            driver = new FirefoxDriver();
        }

        return driver;
    }

    // Viết các hàm khởi chạy cho từng Browser đó
    private static WebDriver initChromeDriver() {
        WebDriver driver;
        System.out.println("Launching Chrome browser...");
        //Set chế độ chạy ẩn danh
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--headless");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        WebDriver driver;
        System.out.println("Launching Edge browser...");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        WebDriver driver;
        System.out.println("Launching Firefox browser...");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }


    public static void closeDriver() {
        //chụp ảnh khi TCs bị Fail, nếu TCs pass thì hàm này không chụp.
//       if (ITestResult.FAILURE== iTestResult.getStatus()){
//           CaptureHelper.takeScreenshot(iTestResult.getName());
//       }
//       //Stop record video
//        CaptureHelper.stopRecord();
        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }

}
