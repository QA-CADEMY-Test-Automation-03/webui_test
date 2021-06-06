package webui.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.test.core.WebDriverAction;

public class Login {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebDriverAction action;
    private By usernameTextField = By.cssSelector("#user");
    private By passwordTextField = By.cssSelector("#password");
    private By loginButton = By.cssSelector("#login");
    private By loginSubmitButton = By.cssSelector("#login-submit");

    public Login(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30);
        this.action = new WebDriverAction(driver, this.wait);
    }

    public Header login(String username, String password){
        this.action.sendText(this.usernameTextField, username);
        this.action.waitForInvisibility(this.passwordTextField);
        this.action.click(this.loginButton);
        this.action.sendText(this.passwordTextField, password);
        this.action.click(this.loginSubmitButton);

        return  new Header(this.driver);
    }
}
