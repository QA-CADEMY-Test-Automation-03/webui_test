package webui.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginError extends AbstractPage {
    @FindBy(css = "#login-error")
    WebElement loginErrorTextArea;

    @FindBy(css = "#login-error a")
    WebElement resetLink;

    public LoginError() {
        super();
    }

    public String getErrorMessage(){
        return this.action.getText(loginErrorTextArea);
    }

    public String getResetLink(){
        return this.action.getAttribute(resetLink, "href");
    }
}
