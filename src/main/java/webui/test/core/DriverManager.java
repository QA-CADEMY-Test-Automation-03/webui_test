package webui.test.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
    Implements singleton pattern to handle a single driver for all the pages
 */
public class DriverManager {
    private static DriverManager driverManager;
    private WebDriver driver;

    private DriverManager(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    public static DriverManager getInstance(){
        if(driverManager == null){
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
