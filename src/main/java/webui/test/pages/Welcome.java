package webui.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.test.core.WebDriverAction;

public class Welcome {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebDriverAction action;
    private String url = "https://trello.com";
    private By loginButton = By.cssSelector("[href*='login']");

    public Welcome(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 35);
        this.action = new WebDriverAction(driver, wait);
        this.driver.get(this.url);
    }

    public Login openLogin(){
        this.action.click(this.loginButton);
        return new Login(this.driver);
    }
}
