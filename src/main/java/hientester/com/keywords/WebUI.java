package hientester.com.keywords;

import com.aventstack.extentreports.Status;
import hientester.com.drivers.DriverManager;
import hientester.com.reports.AllureManager;
import hientester.com.reports.ExtentTestManager;
import hientester.com.utils.LogUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class WebUI {

    private static int TIMEOUT = 10; //time chờ của WebDriverWait
    private static double STEP_TIME = 0.5; // time chờ đợi của hàm sleep
    private static int PAGE_LOAD_TIMEOUT = 40;//time chờ đợi trang load xong


    //2.Hàm sleep theo java
    public static void sleep(double seconds) {
        try {
            Thread.sleep((long) (1000 * seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //3.hàm in r log (println log)LogUtils.info
    public static void logConsole(Object message) {
        LogUtils.info(message);
    }


    public static WebElement getWebElement(By by) {
        return DriverManager.getDriver().findElement(by);

    }

    public static List<WebElement> getWebElements(By by) {
        return DriverManager.getDriver().findElements(by);

    }

    //4.Hàm kểm tra elemnt có tồn tại không
    public static boolean checkElementExist(By by) {
        List<WebElement> listElement = getWebElements(by); //DriverManager.getDriver().findElements(by);

        if (listElement.size() > 0) {
            LogUtils.info("✅Check Element Exist: " + true + "---" + by);
            return true;
        } else {
            LogUtils.info("❌Check Element Exist: " + false + "---" + by + " NOT exist.");
            return false;
        }

    }

    //4. Kiểm tra element có hiển thị
    public static boolean checkElementDisplayed(By by) {
        waitForElementVisible(by);
        boolean check = getWebElement(by).isDisplayed();
        return check;
    }

    public static boolean checkElementIsSelected(By by) {
        WebUI.sleep(2);
        boolean check = getWebElement(by).isSelected();
        return check;
    }

    //5.Hàm get website
    @Step("Open URL: {0}")
    public static void opeURL(String url) {
        DriverManager.getDriver().get(url);
        LogUtils.info("\uD83C\uDF0DOpen Website: " + url);
        //ExtentTestManager.logMessage(Status.INFO, "\uD83C\uDF0DOpen URL: " + url);
    }

    //6.Hàm click vào element
    @Step("Click Element: {0}")
    public static void clickElement(By by) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        waitForElementClickable(by);//thay thế 2 dòng wait ở trên.
        getWebElement(by).click();
        LogUtils.info("\uD83D\uDC49Click Element: " + by);
       // ExtentTestManager.logMessage(Status.INFO, "\uD83D\uDC49Click element: " + by);
    }

    @Step("Click Element: {0} with timeout is {1}s")
    public static void clickElement(By by, int second) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(second));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        waitForElementClickable(by, second);//thay thế 2 dòng wait ở trên.
        getWebElement(by).click();
        LogUtils.info("\uD83D\uDC49Click Element: " + by + " with timeout is " + second + "(s).");
       // ExtentTestManager.logMessage(Status.INFO, "\uD83D\uDC49Click element: " + by);
    }

    //7. Hàm input text vào
    @Step("Input text: {1} on element {0}")
    public static void setText(By by, String value) {
        waitForElementVisible(by);
        getWebElement(by).sendKeys(value);
        LogUtils.info("✍️Input text: " + "'" + value + "'" + " on input: " + by);
        //ExtentTestManager.logMessage(Status.INFO, "✍️Input text: " + "'" + value + "'" + " on input: " + by);
    }

    @Step("Input text: {2} on element {0} with timeout {1}")
    public static void setText(By by, int second, String value) {
        waitForElementVisible(by, second);
        getWebElement(by).sendKeys(value);
        LogUtils.info("✍️Input text: " + "'" + value + "'" + " on input: " + by);
        //ExtentTestManager.logMessage(Status.INFO, "✍️Input text: " + value + " on element " + by);
    }

    //15.1. Hàm setKey
    public static void setTextAndKey(By by, String value, Keys key) {
        waitForPageLoaded();
        getWebElement(by).sendKeys(value, key);
        LogUtils.info("\uD83D\uDC49Set text: " + value + " on element " + by);
    }

    //15.2. Hàm setKey
    public static void setKey(By by, Keys key) {
        waitForPageLoaded();
        getWebElement(by).sendKeys(key);
        LogUtils.info("\uD83D\uDC49Set key: " + key.name() + " on element " + by);
    }

    //8. Hàm input text (tương tự mucj7. nhưng đầy đủ hơn
    @Step("GET TEXT OF ELEMENT: {0} ")
    public static String getElementText(By by) {
        waitForElementVisible(by);
        WebUI.sleep(STEP_TIME);
        String text = DriverManager.getDriver().findElement(by).getText();
        LogUtils.info("✍️GET TEXT OF ELEMENT: '" + by + "'" + " ===> " + text);
        //ExtentTestManager.logMessage(Status.INFO, "✍️Get text of element: " + by);
       // ExtentTestManager.logMessage(Status.INFO, "==> ✍️Text: " + getWebElement(by).getText());

        AllureManager.saveTextLog("✍️===> " + text);
        return text;
    }

    @Step("Get attribute of element: {0}")
    public static String getElementAttribute(By by, String attributeName) {
        waitForElementVisible(by);//thay thế 2 dòng wait ở trên.
        WebUI.sleep(STEP_TIME);
        String value = DriverManager.getDriver().findElement(by).getAttribute(attributeName);
        LogUtils.info("\uD83E\uDDBEGet attribute of element: " + by + " ===> " + value);
        //ExtentTestManager.logMessage(Status.INFO, "\uD83E\uDDBEGet attribute value of element: " + by);
       // ExtentTestManager.logMessage(Status.INFO, "==>\uD83E\uDDBE Attribute value: " + getWebElement(by).getAttribute(attributeName));

        AllureManager.saveTextLog("===> " + value);
        return value;
    }

    //9. Chờ đợi trang load xong mới thao tác
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(PAGE_LOAD_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            LogUtils.info("\uD83D\uDC19Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                LogUtils.error(error.getStackTrace());
                Assert.fail("\uD83D\uDC19FAILED. Timeout waiting for page load.");
            }
        }
    }

    //*** Wait for Element ***
    //10.Wait for Element hiển thị
    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));//hàm chờ đợi element hiển thị
        } catch (Throwable error) {
            LogUtils.error("\uD83E\uDEB2Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("\uD83E\uDEB2Timeout waiting for the element Visible. " + by.toString());

        }
    }

    //10.Wait for Element hiển thị
    public static void waitForElementVisible(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));//hàm chờ đợi element hiển thị
        } catch (Throwable error) {
            LogUtils.error("\uD83E\uDEB2Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("\uD83E\uDEB2Timeout waiting for the element Visible. " + by.toString());

        }
    }

    //11.Wait for Element KO hiển thị
    public static void waitForElementInvisible(By by) {//mặc định
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));//hàm chờ đợi element KHÔNG hiển thị
        } catch (Throwable error) {
            LogUtils.error("\uD83E\uDD82Timeout waiting for the element NOT visible. " + by.toString());
            Assert.fail("\uD83E\uDD82Timeout waiting for the element NOT visible. " + by.toString());

        }
    }

    public static void waitForElementInvisible(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));//hàm chờ đợi element KHÔNG hiển thị
        } catch (Throwable error) {
            LogUtils.error("\uD83E\uDD82Timeout waiting for the element NOT visible. " + by.toString());
            Assert.fail("\uD83E\uDD82Timeout waiting for the element NOT visible. " + by.toString());

        }
    }

    //12.Wait for Element tồn tại
    public static void waitForElementPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));//Hàm chờ đợi element tồn tại
        } catch (Throwable error) {
            LogUtils.error("\uD83E\uDDA2Element not exist. " + by.toString());
            Assert.fail("\uD83E\uDDA2Element not exist. " + by.toString());

        }
    }

    public static void waitForElementPresent(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));//Hàm chờ đợi element tồn tại
        } catch (Throwable error) {
            LogUtils.error("\uD83E\uDDA2Element not exist. " + by.toString());
            Assert.fail("\uD83E\uDDA2Element not exist. " + by.toString());

        }
    }

    //13.Wait forElement tồn tại để click
    public static void waitForElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            LogUtils.error("\uD83D\uDC49Timeout waiting for the element ready to click. " + by.toString());
            Assert.fail("\uD83D\uDC49Timeout waiting for the element ready to click. " + by.toString());

        }
    }

    public static void waitForElementClickable(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            LogUtils.error("\uD83D\uDC49Timeout waiting for the element ready to click. " + by.toString());
            Assert.fail("\uD83D\uDC49Timeout waiting for the element ready to click. " + by.toString());

        }
    }

    //***14. Hàm chụp ảnh màn hình test***
    public static void captureScreenImage(String imageName) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        //Get size screen browser
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        LogUtils.info("Kích thước khung hình: " + screenSize);
        //Khởi tạo kích thước khung hình với kích cỡ trên
        Rectangle screenRectangle = new Rectangle(screenSize);
        //Tạo hình chụp với độ lớn khung đã tạo trên
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        //Lưu hình vào dạng file với dạng png
        File file = new File("src/test/resources/screenshots/" + imageName + ".png");
        try {
            ImageIO.write(image, "png", file);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Cuộn đến vị tr phần tử chỉ định
     *
     * @param element
     * @param position nếu giá trị "true" thì cuộn đến phía trên của element. Nếu giá trị "false" thì cuộn xuoog phía dưới element đó.
     */
    //18. Hàm cuộn chuột đến element
    public static void scrollToElement(By element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(element));
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //17. Cuộn chuột đến tọa độ x,y
    public static void scrollToPosition(int X, int Y) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(" + X + "," + Y + ");");
    }

    //19. Move chuột vào element
    public static boolean moveToElement(By toElement) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return false;
        }
    }

    //20. Move chuột vào tọa độ x,y
    public static boolean moveToOffset(int X, int Y) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveByOffset(X, Y).build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return false;
        }
    }

    //21. Hover chuột vào element(giống hàm move)
    public static boolean hoverElement(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            LogUtils.error("\uD83E\uDEF0Hover on element: " + by);
            //ExtentTestManager.logMessage(Status.FAIL, "\uD83E\uDEF0Hover on element " + by);
            return false;
        }

    }

    //22.Hover chuột vào element(giống hàm move)
    public static boolean mouseHover(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //23. Hàm kéo thả
    public static boolean dragAndDrop(By fromElement, By toElement) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.dragAndDrop(getWebElement(fromElement), getWebElement(toElement)).perform();
            //action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return false;
        }
    }

    public static boolean dragAndDropElement(By fromElement, By toElement) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return false;
        }
    }

    public static boolean dragAndDropOffset(By fromElement, int X, int Y) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            //Tính từ vị trí click chuột đầu tiên (clickAndHold)
            action.clickAndHold(getWebElement(fromElement)).pause(1).moveByOffset(X, Y).release().build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return false;
        }
    }

    //24. Hàm nhấn phím (ở bàn phím)
    public static boolean pressENTER() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean pressESC() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean pressF11() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_F11);
            robot.keyRelease(KeyEvent.VK_F11);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //25. Hàm ô màu viền đỏ cho Element trên website
    public static WebElement highLightElement(By by) {
        // Tô màu border ngoài chính element chỉ định - màu đỏ (có thể đổi màu khác)
        if (DriverManager.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.border='3px solid blue'", getWebElement(by));
            sleep(STEP_TIME);
        }
        return getWebElement(by);
    }

    //Tự truyền tham số (color tuỳ ý = biến colorName)
    public static WebElement highLightElement(By by, String colorName) {
        // Tô màu border ngoài chính element chỉ định - màu đỏ (có thể đổi màu khác)
        if (DriverManager.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.border='3px solid" + colorName + "'", getWebElement(by));
            sleep(STEP_TIME);
        }
        return getWebElement(by);
    }

    //***Assert and verify***
    //26.*Trả KẾT QUẢ trực tiếp là PASS/FAILS. Hàm KIỂM TRA CỨNG đúng sai(bằng) của actual với expected.
    public static void assertEquals(Object actual, Object expected, String message) {
        waitForPageLoaded();
        LogUtils.info("\uD83C\uDD97Assert equals: " + actual + " \uD83D\uDFF0 " + expected);
        Assert.assertEquals(actual, expected, message);
    }

    //Hàm kiểm tra trả kết quả là true/false(trả vè boolean-> ÍT DÙNG)
    public static boolean verifyEquals(Object actual, Object expected) {
        waitForPageLoaded();
        LogUtils.info("↪️Verify equals: " + actual.toString() + " \uD83D\uDFF0 " + expected.toString());
        boolean result = actual.equals(expected);
        return result;
    }

    //26.*Hàm kiểm tra chứa
    public static void assertContains(String actual, String expected, String message) {
        waitForPageLoaded();
        LogUtils.info("\uD83D\uDD1CAssert contains: " + actual + " \uD83D\uDFF0 " + expected);
        boolean check = actual.contains(expected);
        Assert.assertTrue(check, message);
    }

    //Hàm kiểm tra trả kết quả là true/false (trả vè boolean)
    public static boolean verifyEqualsContains(String actual, String expected) {
        waitForPageLoaded();
        LogUtils.info("↪️Verify contains: " + actual.toString() + " \uD83D\uDFF0 " + expected.toString());
        boolean result = actual.equals(expected);
        return result;
    }
}