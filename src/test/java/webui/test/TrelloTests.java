package webui.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import webui.test.core.WebDriverAction;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class TrelloTests {

    private WebDriver driver;
    //WebDriverWait object to handle the timeout and expected conditions of explicit wait
    private WebDriverWait wait;
//    private Wait<WebDriver> fluentWait;
    private WebDriverAction action;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions =  new ChromeOptions();
        //Enable headless mode for chrome browser
//        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().setSize(new Dimension(1920, 1080));

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        //Explicit wait
        wait = new WebDriverWait(driver, 35);
        action = new WebDriverAction(driver, wait);
        //Fluent wait
//        fluentWait = new FluentWait<>(driver)
//                     .withTimeout(Duration.ofSeconds(20))
//                     .pollingEvery(Duration.ofSeconds(1))
//                     .ignoring(NoSuchElementException.class);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testLogin(){
        //Load home page
        driver.get("https://trello.com/");
        //Click login button
//        WebElement loginButton = fluentWait.until(new Function<WebDriver, WebElement>() {
//            @Override
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(By.cssSelector("[href*='login2']"));
//            }
//        });
//        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href*='login']")));
//        WebElement loginButton = driver.findElement(By.cssSelector("[href*='login']"));
//        loginButton.click();
        action.click(By.cssSelector("[href*='login']"));

//        sleep(4);

        //Set user name
//        WebElement userTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#user")));
//        WebElement userTextField = driver.findElement(By.cssSelector("#user"));
//        userTextField.sendKeys("joseccb1948@outlook.com");
        action.sendText(By.cssSelector("#user"), "joseccb1948@outlook.com");

//        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector("#password"))));
        action.waitForInvisibility(By.cssSelector("#password"));
        //Click first Atlassian login button
//        WebElement loginAtlasianButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login")));
//        WebElement loginAtlasianButton = driver.findElement(By.cssSelector("#login"));
//        loginAtlasianButton.click();
        action.click(By.cssSelector("#login"));

        //Wait for second login page
//        sleep(3);

        //Set password
//        WebElement passwordTextField = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#password"))));
//        WebElement passwordTextField = driver.findElement(By.cssSelector("#password"));
//        passwordTextField.sendKeys("Control*1234");
        action.sendText(By.cssSelector("#password"), "Control*1234");

//        sleep(3);

        //Click second login button
//            WebElement loginSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-submit")));
//        WebElement loginSubmitButton = driver.findElement(By.cssSelector("#login-submit"));
//        loginSubmitButton.click();
        action.click(By.cssSelector("#login-submit"));

//        sleep(20);

        //Click profile icon
//        WebElement profileMenuButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".js-open-header-member-menu")));
//        WebElement profileMenuButton = driver.findElement(By.cssSelector(".js-open-header-member-menu"));
//        profileMenuButton.click();
        action.click(By.cssSelector(".js-open-header-member-menu"));

//        sleep(3);

        //Validate email account
//        WebElement accountNameLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-test-id='header-member-menu-popover']/descendant::ul/div/div/span")));
//        WebElement accountNameLabel = driver.findElement(By.xpath("//section[@data-test-id='header-member-menu-popover']/descendant::ul/div/div/span"));
//        String actualAccountName = accountNameLabel.getText();
        String expectedAccountName = "joseccb1948@outlook.com";
        String actualAccountName = action.getText(By.xpath("//section[@data-test-id='header-member-menu-popover']/descendant::ul/div/div/span"));

        Assert.assertEquals(expectedAccountName, actualAccountName);
    }

    @Test
    public void testCreateBoard(){
        login();
        //Go to Boards menu
        WebElement boardsButton = driver.findElement(By.cssSelector("[href*='boards']"));
        boardsButton.click();
//        action.click(By.cssSelector("[href*='boards']"));

        //Open boards creation menu
        WebElement createNewBoardButton = driver.findElement(By.xpath("//div[@class='content-all-boards']/div[2]/descendant::li[@data-test-id='create-board-tile']"));
        createNewBoardButton.click();
//        action.click(By.xpath("//div[@class='content-all-boards']/div[2]/descendant::li[@data-test-id='create-board-tile']"));

//        sleep(4);

        //Set board title
        WebElement boardTitleTextField = driver.findElement(By.cssSelector("[data-test-id='create-board-title-input']"));
        boardTitleTextField.sendKeys("My board");
//        action.sendText(By.cssSelector("[data-test-id='create-board-title-input']"), "My board");

        //Click create board
        WebElement createBoardButton = driver.findElement(By.cssSelector("[data-test-id='create-board-submit-button']"));
        createBoardButton.click();
//        action.click(By.cssSelector("[data-test-id='create-board-submit-button']"));

//        sleep(4);

        //Validate board title
        WebElement boardTitleLabel = driver.findElement(By.cssSelector(".mod-board-name"));
        String actualBoardTitle = boardTitleLabel.getText();
//        String actualBoardTitle = action.getText(By.cssSelector(".mod-board-name"));
        String expectedBoardTitle = "My board";

        Assert.assertEquals(expectedBoardTitle, actualBoardTitle);

    }

    //Practice 2.1
    @Test
    public void testLoginP2(){
        //Load home page
        driver.get("https://trello.com/");

        //Get text from Welcome page
        WebElement welcomeMessage = driver.findElement(By.cssSelector("#hero h1"));
        String actualWelcomeMessage = welcomeMessage.getText();
        String expectedWelcomeMessage = "Trello helps teams move work forward.";

        //Validate Welcome text
        Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage);

        //Click login button
        WebElement loginButton = driver.findElement(By.cssSelector("[href*='login']"));
        loginButton.click();
//        sleep(4);

        //Set user name
        WebElement userTextField = driver.findElement(By.cssSelector("#user"));
        userTextField.sendKeys("joseccb1948@outlook.com");

        //Click first Atlassian login button
        WebElement loginAtlasianButton = driver.findElement(By.cssSelector("#login"));
        loginAtlasianButton.click();

        //Wait for second login page
        sleep(3);

        //Set password
        WebElement passwordTextField = driver.findElement(By.cssSelector("#password"));
        passwordTextField.sendKeys("Control*1234");

//        sleep(3);

        //Click second login button
        WebElement loginSubmitButton = driver.findElement(By.cssSelector("#login-submit"));
        loginSubmitButton.click();
//        sleep(20);

        //Validate email account
        List<WebElement> leftMenuItems = driver.findElements(By.cssSelector(".home-left-sidebar-container>div>ul a"));
        String actualFirstItemText = leftMenuItems.get(0).getText();
        String actualSecondItemText = leftMenuItems.get(1).getText();
        String actualThirdItemText = leftMenuItems.get(2).getText();

        Assert.assertTrue(actualFirstItemText.contains("Boards"));
        Assert.assertTrue(actualSecondItemText.contains("Templates"));
        Assert.assertTrue(actualThirdItemText.contains("Home"));

    }

    //Practice 2.2
    @Test
    public void testCreateBoardFromCreateMenuP2(){
        login();
        //Go to Create menu
        WebElement createMenuButton = driver.findElement(By.cssSelector("[data-test-id='header-create-menu-button']"));
        createMenuButton.click();
//        action.click(By.cssSelector("[data-test-id='header-create-menu-button']"));

        //Open boards creation menu
        WebElement createNewBoardButton = driver.findElement(By.cssSelector("[data-test-id='header-create-board-button']"));
        createNewBoardButton.click();
//        action.click(By.cssSelector("[data-test-id='header-create-board-button']"));

//        sleep(4);

        //Set board title
        WebElement boardTitleTextField = driver.findElement(By.cssSelector("[data-test-id='create-board-title-input']"));
        boardTitleTextField.sendKeys("My board");
//        action.sendText(By.cssSelector("[data-test-id='create-board-title-input']"), "My board");

        //Set public
        WebElement privacyOptions = driver.findElement(By.xpath("//ul/preceding-sibling::div/button[2]"));
        privacyOptions.click();
//        action.click(By.xpath("//ul/preceding-sibling::div/button[2]"));
        WebElement publicOption = driver.findElement(By.xpath("//section/descendant::li[3]"));
        publicOption.click();
//        action.click(By.xpath("//section/descendant::li[3]"));

        // Click Yes to confirm
        WebElement confirmButton = driver.findElement(By.xpath("//section/descendant::div/button"));
        confirmButton.click();
//        action.click(By.xpath("//section/descendant::div/button"));

        //Click create board
        WebElement createBoardButton = driver.findElement(By.cssSelector("[data-test-id='create-board-submit-button']"));
        createBoardButton.click();
//        action.click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        sleep(4);

        //Validate board title
        WebElement boardTitleLabel = driver.findElement(By.cssSelector(".mod-board-name"));
        String actualBoardTitle = boardTitleLabel.getText();
//        String actualBoardTitle = action.getText(By.cssSelector(".mod-board-name"));
        String expectedBoardTitle = "My board";

        Assert.assertEquals(expectedBoardTitle, actualBoardTitle);

    }


    public void sleep(int timeInSeconds){
        try{
            Thread.sleep(timeInSeconds*1000);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void login(){
        driver.get("https://trello.com/");
        WebElement loginButton = driver.findElement(By.cssSelector("[href*='login']"));
        loginButton.click();

//        sleep(3);

        WebElement userTextField = driver.findElement(By.cssSelector("#user"));
        userTextField.sendKeys("joseccb1948@outlook.com");

        WebElement loginAtlasianButton = driver.findElement(By.cssSelector("#login"));
        loginAtlasianButton.click();

        sleep(3);

        WebElement passwordTextField = driver.findElement(By.cssSelector("#password"));
        passwordTextField.sendKeys("Control*1234");

//        sleep(3);

        WebElement loginSubmitButton = driver.findElement(By.cssSelector("#login-submit"));
        loginSubmitButton.click();

//        sleep(5);

    }


}
