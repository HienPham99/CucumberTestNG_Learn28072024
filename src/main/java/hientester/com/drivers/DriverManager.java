package hientester.com.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    //Thay thế cho tất cả giá trị driver bình thường trong project
    public static WebDriver getDriver() {
        return driver.get();
    }

    //Dùng tại BaseTest vị trí Before (cần set giá trị driver trước khi chạy TCs)
    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    //Dùng tại BaseTest vị trí After (để reset gtri driver về null
    // và xóa luôn vị trí của driver trong TheadLocal sao mỗi TCs)
    public static void quit() {
        if (DriverManager.driver.get() != null) {
            DriverManager.driver.get().quit();
            driver.remove();
        }

    }

    public static void close(){
        DriverManager.driver.get().close();
    }
}
