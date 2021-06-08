package webui.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractPage {
    @FindBy(css = ".js-open-header-member-menu")
    private WebElement profileMenuButton;

    @FindBy(css = "[data-test-id='header-create-menu-button']")
    private WebElement createMenuButton;

    public Header(){
        super();
    }

    public Profile openProfileMenu(){
        this.action.click(this.profileMenuButton);
        return new Profile();
    }

    public CreateMenu openCreateMenu(){
        this.action.click(createMenuButton);
        return new CreateMenu();
    }
}
