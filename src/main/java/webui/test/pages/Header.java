package webui.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.test.core.WebDriverAction;

public class Header {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebDriverAction action;

    private By profileMenuButton = By.cssSelector(".js-open-header-member-menu");

    public Header(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 20);
        this.action = new WebDriverAction(driver, this.wait);
    }

    public Profile openProfileMenu(){
        this.action.click(this.profileMenuButton);
        return new Profile(this.driver);
    }
}
