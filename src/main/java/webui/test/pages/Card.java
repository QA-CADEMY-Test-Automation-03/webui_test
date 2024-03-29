package webui.test.pages;

import org.openqa.selenium.By;
import webui.test.utils.CardObject;

public class Card extends AbstractPage {

    private String CARD_NAME_XPATH = "//span[text()='%s']";

    public String getCardByTitle(String cardName) {
        return action.getText(By.xpath(String.format(this.CARD_NAME_XPATH, cardName)));
    }

    public String getCardByTitle(CardObject cardObject) {
        return action.getText(By.xpath(String.format(this.CARD_NAME_XPATH, cardObject.getTitle())));
    }

}
