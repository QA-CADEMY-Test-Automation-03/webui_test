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

        sleep(3);

        //Set user name
        WebElement userTextField = driver.findElement(By.cssSelector("#user"));
        userTextField.sendKeys("joseccb1948@outlook.com");

        //Click first Atlassian login button
        WebElement loginAtlasianButton = driver.findElement(By.cssSelector("#login"));
        loginAtlasianButton.click();

        sleep(3);

        //Set password
        WebElement passwordTextField = driver.findElement(By.cssSelector("#password"));
        passwordTextField.sendKeys("Control*1234");

        sleep(3);

        //Click second login button
        WebElement loginSubmitButton = driver.findElement(By.cssSelector("#login-submit"));
        loginSubmitButton.click();

        sleep(3);

        //Click profile icon
        WebElement profileMenuButton = driver.findElement(By.cssSelector(".js-open-header-member-menu"));
        profileMenuButton.click();

        sleep(3);

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

    @Test
    public void testCreateList(){
        createBoard();
        //Set list title
        WebElement listTitleFieldText = driver.findElement(By.cssSelector(".list-name-input"));
        listTitleFieldText.sendKeys("My list");

        //Add list
        WebElement addListButton = driver.findElement(By.cssSelector(".mod-list-add-button"));
        addListButton.click();

        //Validate list title
        WebElement listTitleLabel = driver.findElement(By.cssSelector(".list-header"));
        String actualListName = listTitleLabel.getText();
        String expectedListName = "My list";

        Assert.assertEquals(expectedListName, actualListName);
    }

    @Test
    public void testCreateCard(){
        createlist();
        //Open creation card menu
        WebElement addCardOption = driver.findElement(By.cssSelector(".open-card-composer"));
        addCardOption.click();

        //Set card title
        WebElement cardTitleTextArea = driver.findElement(By.cssSelector(".js-card-title"));
        cardTitleTextArea.sendKeys("My card");

        //Press Add card button
        WebElement addCardButton = driver.findElement(By.cssSelector(".js-add-card"));
        addCardButton.click();

        //Validate card title
        WebElement cardTitleLabel = driver.findElement(By.cssSelector(".js-card-details"));
        String actualCardTitle = cardTitleLabel.getText();
        String expectedCardTitle = "My card";

        Assert.assertEquals(expectedCardTitle, actualCardTitle);

    }

    @Test
    public void testAddDueDate(){
        createCard();
        //Open Card
        WebElement cardElement = driver.findElement(By.cssSelector(".list-card-title"));
        cardElement.click();
        sleep(2);
        //Open Due Date
        WebElement dueDateButton = driver.findElement(By.cssSelector(".js-add-due-date"));
        dueDateButton.click();
        sleep(3);
        //Click Next month
        WebElement nextButton = driver.findElement(By.cssSelector(".pika-next"));
        nextButton.click();
        //Select date 1
        WebElement dateToPick = driver.findElement(By.xpath("//button[text()='1']"));
        dateToPick.click();
        //Select reminder of 10 min
        WebElement reminderSelector = driver.findElement(By.cssSelector(".js-custom-reminder"));
        Select selector = new Select(reminderSelector);
        selector.selectByValue("10");

        List<WebElement> selected = selector.getAllSelectedOptions();
        for (WebElement element: selected) {
            String content = element.getText();
            System.out.println("selected element: " + content);
        }
        selector.selectByVisibleText("15 Minutes Before");
        selector.selectByIndex(5);

        WebElement saveButton = driver.findElement(By.cssSelector(".wide.confirm"));
        saveButton.click();

        WebElement dueDateLabel = driver.findElement(By.cssSelector(".card-detail-due-date-text"));
        String dueDate = dueDateLabel.getText();
        Assert.assertTrue(dueDate.contains("Feb 1"));

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

    private void createBoard(){
        login();
        WebElement boardsButton = driver.findElement(By.cssSelector("[href*='boards']"));
        boardsButton.click();

        WebElement createNewBoardButton = driver.findElement(By.xpath("//div[@class='content-all-boards']/div[2]/descendant::li[@data-test-id='create-board-tile']"));
        createNewBoardButton.click();

        sleep(4);

        WebElement boardTitleTextField = driver.findElement(By.cssSelector("[data-test-id='create-board-title-input']"));
        boardTitleTextField.sendKeys("My board");


        WebElement createBoardButton = driver.findElement(By.cssSelector("[data-test-id='create-board-submit-button']"));
        createBoardButton.click();

        sleep(4);
    }

    private void createlist(){
        createBoard();
        WebElement listTitleFieldText = driver.findElement(By.cssSelector(".list-name-input"));
        listTitleFieldText.sendKeys("My list");

        sleep(3);
        WebElement addListButton = driver.findElement(By.cssSelector(".mod-list-add-button"));
        addListButton.click();

        sleep(2);
    }

    private void createCard(){
        createlist();

        WebElement addCardOption = driver.findElement(By.cssSelector(".open-card-composer"));
        addCardOption.click();

        WebElement cardTitleTextArea = driver.findElement(By.cssSelector(".js-card-title"));
        cardTitleTextArea.sendKeys("My card");

        WebElement addCardButton = driver.findElement(By.cssSelector(".js-add-card"));
        addCardButton.click();

        sleep(2);
    }
}
