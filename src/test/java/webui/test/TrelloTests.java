package webui.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TrelloTests {

    private WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions =  new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().setSize(new Dimension(1920, 1080));
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
        WebElement loginButton = driver.findElement(By.cssSelector("[href*='login']"));
        loginButton.click();

//        sleep(3);

        //Set user name
        WebElement userTextField = driver.findElement(By.cssSelector("#user"));
        userTextField.sendKeys("joseccb1948@outlook.com");

        //Click first Atlassian login button
        WebElement loginAtlasianButton = driver.findElement(By.cssSelector("#login"));
        loginAtlasianButton.click();

//        sleep(3);

        //Set password
        WebElement passwordTextField = driver.findElement(By.cssSelector("#password"));
        passwordTextField.sendKeys("Control*1234");

//        sleep(3);

        //Click second login button
        WebElement loginSubmitButton = driver.findElement(By.cssSelector("#login-submit"));
        loginSubmitButton.click();

//        sleep(3);

        //Click profile icon
        WebElement profileMenuButton = driver.findElement(By.cssSelector(".js-open-header-member-menu"));
        profileMenuButton.click();

//        sleep(3);

        //Validate email account
        WebElement accountNameLabel = driver.findElement(By.xpath("//section[@data-test-id='header-member-menu-popover']/descendant::ul/div/div/span"));
        String actualAccountName = accountNameLabel.getText();
        String expectedAccountName = "joseccb1948@outlook.com";

        Assert.assertEquals(expectedAccountName, actualAccountName);
    }

    @Test
    public void testCreateBoard(){
        login();
        //Go to Boards menu
        WebElement boardsButton = driver.findElement(By.cssSelector("[href*='boards']"));
        boardsButton.click();

        //Open boards creation menu
        WebElement createNewBoardButton = driver.findElement(By.xpath("//div[@class='content-all-boards']/div[2]/descendant::li[@data-test-id='create-board-tile']"));
        createNewBoardButton.click();

        sleep(4);

        //Set board title
        WebElement boardTitleTextField = driver.findElement(By.cssSelector("[data-test-id='create-board-title-input']"));
        boardTitleTextField.sendKeys("My board");

        //Click create board
        WebElement createBoardButton = driver.findElement(By.cssSelector("[data-test-id='create-board-submit-button']"));
        createBoardButton.click();

        sleep(4);

        //Validate board title
        WebElement boardTitleLabel = driver.findElement(By.cssSelector(".mod-board-name"));
        String actualBoardTitle = boardTitleLabel.getText();
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

        sleep(3);

        WebElement userTextField = driver.findElement(By.cssSelector("#user"));
        userTextField.sendKeys("joseccb1948@outlook.com");

        WebElement loginAtlasianButton = driver.findElement(By.cssSelector("#login"));
        loginAtlasianButton.click();

        sleep(3);

        WebElement passwordTextField = driver.findElement(By.cssSelector("#password"));
        passwordTextField.sendKeys("Control*1234");

        sleep(3);

        WebElement loginSubmitButton = driver.findElement(By.cssSelector("#login-submit"));
        loginSubmitButton.click();

        sleep(5);

    }


}
