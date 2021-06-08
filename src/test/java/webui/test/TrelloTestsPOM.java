package webui.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webui.test.core.DriverManager;
import webui.test.pages.*;

public class TrelloTestsPOM {
//    private WebDriver driver;

    @Before
    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
//        driver.quit();
        DriverManager.getInstance().getDriver().quit();
    }

    @Test
    public void testLogin(){
        Welcome welcome = new Welcome();

        Login login = welcome.openLogin();
        Header header = login.login("joseccb1948@outlook.com", "Control*1234");
        Profile profile = header.openProfileMenu();
        String actualAccountEmail = profile.getAccountEmail();
        String expectedAccountEmail = "joseccb1948@outlook.com";

        Assert.assertEquals(expectedAccountEmail, actualAccountEmail);

    }

    @Test
    public void testCreateBoardFromCreateMenu(){
        Welcome welcome = new Welcome();
        Login login = welcome.openLogin();
        Header header = login.login("joseccb1948@outlook.com", "Control*1234");

        CreateMenu createMenu = header.openCreateMenu();
        BoardCreationForm boardCreationForm = createMenu.openCreateBoardForm();
        Board board = boardCreationForm.createBoard("My board");
        String actualBoardTitle = board.getBoardTitle();
        String expectedBoardTitle = "My board";

        Assert.assertEquals(expectedBoardTitle, actualBoardTitle);
    }
}
