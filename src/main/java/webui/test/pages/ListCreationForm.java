package webui.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListCreationForm extends AbstractPage {
    @FindBy(css = ".list-name-input")
    private WebElement listTitleTextField;

    @FindBy(css = ".mod-list-add-button")
    private WebElement addListButton;

    public ListCreationForm() {
        super();
    }

    public ListCreated createList(String listTitle){
        this.action.sendText(this.listTitleTextField, listTitle);
        this.action.click(this.addListButton);
        return new ListCreated();
    }
}
