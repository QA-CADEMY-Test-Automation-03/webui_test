package webui.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Board extends AbstractPage {
    @FindBy(css = ".mod-board-name")
    private WebElement boardTitleLabel;

    public Board() {
        super();
    }

    public String getBoardTitle(){
        return this.action.getText(boardTitleLabel);
    }
}
