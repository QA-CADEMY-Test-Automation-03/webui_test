package webui.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.test.core.WebDriverAction;

public class Profile {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebDriverAction action;

    private By accountEmailLabel = By.xpath("//section[@data-test-id='header-member-menu-popover']/descendant::ul/div/div/span");

    public Profile(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30);
        this.action = new WebDriverAction(driver, this.wait);
    }

    public String getAccountEmail(){
        return this.action.getText(this.accountEmailLabel);
    }
}
