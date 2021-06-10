package webui.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AttachMenu extends AbstractPage {
    @FindBy(css = ".js-attach-file")
    WebElement computerButton;

    public CardPopOver attachFileByComputer(String path) {
        this.computerButton.sendKeys(path);
        return new CardPopOver();
    }
}
