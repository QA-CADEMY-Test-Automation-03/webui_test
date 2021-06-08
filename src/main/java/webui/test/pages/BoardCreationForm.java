package webui.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardCreationForm extends AbstractPage {
    @FindBy(css = "[data-test-id='create-board-title-input']")
    private WebElement boardTitleFieldText;

    @FindBy(css = "[data-test-id='create-board-submit-button']")
    private WebElement createBoardButton;

    public BoardCreationForm() {
        super();
    }

    public Board createBoard(String boardTitle){
        this.action.sendText(boardTitleFieldText, boardTitle);
        this.action.click(createBoardButton);
        return new Board();
    }
}
