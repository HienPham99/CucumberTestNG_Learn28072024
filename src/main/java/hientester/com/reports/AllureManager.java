package hientester.com.reports;

import hientester.com.drivers.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureManager {

    //Text attachments for Allure. Ghi log
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    //html attachments for Allure.
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html){return html;}

    //Screenshot attachments for Allure. Chụp màn hình
    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
