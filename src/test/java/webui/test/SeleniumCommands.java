package webui.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCommands {
    @Test
    public void testSeleniumElements(){
        // Configure chrome driver
        //Windows:
        //System.setProperty("webdriver.chrome.driver", "e:\\qa-webui\\chromedriver_win32\\chromedriver.exe");
        //macOS/linux:
        System.setProperty("webdriver.chrome.driver", "/Users/jose.colina/Documents/jose/webui/chromedriver");

//        Setup chromedriver using WebDriverManager
//        WebDriverManager.chromedriver().setup();
//        WebDriverManager.chromedriver().driverVersion("2.40").setup();

        // Create webDriver, open browser
        WebDriver driver = new ChromeDriver();
        // Maximize browser
//        driver.manage().window().maximize();

        //Headless mode
//        ChromeOptions chromeOptions =  new ChromeOptions();
//        chromeOptions.addArguments("--headless");
//        driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().setSize(new Dimension(1920, 1080));

        // Navigate to selenium site
        driver.get("https://selenium.dev");
//        driver.navigate().to("https://selenium.dev");

        // Find download button
//        WebElement downloadButton = driver.findElement(By.cssSelector(".download-button.ide"));
//        downloadButton.click();
        // Find all the download buttons
//        List<WebElement> downloadButtons = driver.findElements(By.cssSelector(".download-button"));
//        String firstLocator = downloadButtons.get(0).getAttribute("class");
//        String secondLocator = downloadButtons.get(1).getAttribute("class");
//        String thirdLocator = downloadButtons.get(2).getAttribute("class");
//        downloadButtons.get(1).click();
//        WebElement searchBox = driver.findElement(By.xpath("//input[@name='search']"));
//        searchBox.sendKeys("selenium ide");
//        searchBox.clear();
//        searchBox.sendKeys("selenium webdriver");
//        searchBox.sendKeys(Keys.ENTER);
// Get text from webelement
//        WebElement homeMessage = driver.findElement(By.xpath("//h1[@class='sub-header']"));
//        String messageText = homeMessage.getText();
        // Close current tab or window
//        driver.close();
        // Close browser and kill drivers instances
        driver.quit();
    }
}
