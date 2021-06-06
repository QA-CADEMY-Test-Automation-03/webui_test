package webui.test.core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverAction {

    private WebDriver driver;
    private WebDriverWait wait;

    public WebDriverAction(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    //Clicks element given a locator
    //previously makes sure that the element is clickable through explicit wait
    public void click(By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    //Sends text to element given a locator
    //previously makes sure that the element is clickable through explicit wait
    public void sendText(By locator, String text){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(text);
    }

    //Gets text from a given locator
    //previously verifies if element is visible
    public String getText(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    //Waits for element to be visible
    public boolean isElementVisible(By locator){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch(NoSuchElementException e){
            return false;
        }
    }

    //Waits for element to be invisible
    public void waitForInvisibility(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
