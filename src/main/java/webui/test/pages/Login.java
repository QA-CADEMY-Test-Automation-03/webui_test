package webui.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends AbstractPage {
    @FindBy(css = "#user")
    private WebElement usernameTextField;

    @FindBy(css = "#password")
    private WebElement passwordTextField;

    @FindBy(css = "#login")
    private WebElement loginButton;

    @FindBy(css = "#login-submit")
    private WebElement loginSubmitButton;

    @FindBy(css = "#error")
    private WebElement errorMessage;

    public Login(){
        super();
    }

    public Header login(String username, String password){
        this.action.sendText(this.usernameTextField, username);
        this.action.waitForInvisibility(this.passwordTextField);
        this.action.click(this.loginButton);
        this.action.sendText(this.passwordTextField, password);
        this.action.click(this.loginSubmitButton);
        return  new Header();
    }

    public void loginInSingleStep(String username, String password){
        this.action.sendText(this.usernameTextField, username);
        this.action.sendText(this.passwordTextField, password);
        this.action.click(this.loginButton);
    }

    public String getErrorMessage(){
        return this.action.getText(errorMessage);
    }
}
