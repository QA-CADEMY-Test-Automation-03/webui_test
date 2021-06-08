package webui.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile extends AbstractPage {
    @FindBy(xpath = "//section[@data-test-id='header-member-menu-popover']/descendant::ul/div/div/span")
    private WebElement accountEmailLabel;

    public Profile(){
        super();
    }

    public String getAccountEmail(){
        return this.action.getText(this.accountEmailLabel);
    }
}
