package webui.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Board extends AbstractPage {
    @FindBy(css = ".mod-board-name")
    private WebElement boardTitleLabel;

    private String CARD_XPATH = "//span[text()='%s']";
    private String LIST_XPATH = "//textarea[text()='%s']";

    public Board() {
        super();
    }

    public String getBoardTitle(){
        return this.action.getText(boardTitleLabel);
    }

    public void moveCard(String cardSource, String listTarget) {
        action.dragAndDrop(By.xpath(String.format(CARD_XPATH, cardSource)), By.xpath(String.format(LIST_XPATH, listTarget)));
    }
}
