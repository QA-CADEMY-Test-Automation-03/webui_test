package webui.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webui.test.pages.Header;
import webui.test.pages.Login;
import webui.test.pages.Profile;
import webui.test.pages.Welcome;

public class TrelloTestsPOM {
    private WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testLogin(){
        Welcome welcome = new Welcome(driver);

        Login login = welcome.openLogin();
        Header header = login.login("joseccb1948@outlook.com", "Control*1234");
        Profile profile = header.openProfileMenu();
        String actualAccountEmail = profile.getAccountEmail();
        String expectedAccountEmail = "joseccb1948@outlook.com";

        Assert.assertEquals(expectedAccountEmail, actualAccountEmail);

    }

    @Test
    public void testCreateBoardFromCreateMenu(){
    }
}
