package webui.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateMenu extends AbstractPage {
    @FindBy(css = "[data-test-id='header-create-board-button']")
    private WebElement createMenuButton;

    public CreateMenu() {
        super();
    }

    public BoardCreationForm openCreateBoardForm(){
        this.action.click(createMenuButton);
        return new BoardCreationForm();
    }
}
