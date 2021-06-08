package webui.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Welcome extends AbstractPage {
    private String url = "https://trello.com";

    @FindBy(css = "[href*='login']")
    private WebElement loginButton;

    public Welcome(){
        super();
        this.driver.get(this.url);
    }

    public Login openLogin(){
        this.action.click(this.loginButton);
        return new Login();
    }
}
