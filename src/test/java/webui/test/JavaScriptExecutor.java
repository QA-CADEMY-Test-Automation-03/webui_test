package webui.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.test.core.DriverManager;
import webui.test.core.WebDriverAction;
import webui.test.pages.Header;
import webui.test.pages.Login;
import webui.test.pages.Welcome;

public class JavaScriptExecutor {

    @Test
    public void testJavaScriptExecutor(){
        //Open browser
        WebDriver driver = DriverManager.getInstance().getDriver();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebDriverAction action = new WebDriverAction(driver, wait);
        //Initialize the javascript executor
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        Welcome welcome = new Welcome();
        Login login = welcome.openLogin();
        Header header = login.login("joseccb1948@outlook.com", "Control*1234");

        WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test-id='header-member-menu-button']")));
        //Navigate to Welcome board
        driver.navigate().to("https://trello.com/b/9nq5TWIS/welcome-to-trello");

//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test-id='header-search-input']")));
//        WebElement cardTemplates = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[text()='My new list']/parent::div/following-sibling::div/*[contains(@class,'js-card-templates-button')]/descendant::span")));
//        WebElement listTarget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='board']/div[3]")));
//        WebElement cardSource = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='test']")));
//        WebElement card = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Implement login']")));


        WebElement boardMenuButton = driver.findElement(By.cssSelector("[data-test-id='header-boards-menu-button']"));
        javascriptExecutor.executeScript("arguments[0].click();", boardMenuButton);
        WebElement boardMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test-id='header-boards-menu-popover']")));
        WebElement boardsScrollable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test-id='header-boards-menu-popover']")));
//        javascriptExecutor.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", boardsScrollable);
        javascriptExecutor.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight - arguments[0].clientHeight", boardsScrollable);
        javascriptExecutor.executeScript("arguments[0].scrollTop = 0", boardsScrollable);
        javascriptExecutor.executeScript("$(\"#content\").animate({scrollTop:\"300px\"})");

        //Initialize the actions object
//        Actions actions = new Actions(driver);
//
//        //Call and execute the dragAndDrop action
//        actions.dragAndDrop(cardSource, listTarget).perform();
//
//        //Call and execute the context click action, previous action is not executed
//        actions.contextClick(card).perform();
//
//        //Create action object which store the previous action
//        Action actionSeries = actions.build();
//        //Perform the action built in previous step
//        actionSeries.perform();
//        //Rpeat the action since action object can be executed any times
//        actionSeries.perform();
//
//        //send keys to search box and move to display the tooltip
//        actions.sendKeys(searchBox, "tes two sequence ...").moveToElement(cardTemplates).perform();
//
//        //Load action to move element
//        actions.moveToElement(cardTemplates).perform();
//        //Assing this new actions in the action object
//        actionSeries = actions.build();
//        //THe new action is executed
//        actionSeries.perform();


        driver.quit();
    }
}
