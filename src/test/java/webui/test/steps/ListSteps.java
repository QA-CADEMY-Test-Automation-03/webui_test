package webui.test.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import webui.test.pages.ListCreated;
import webui.test.pages.ListCreationForm;

public class ListSteps {
    private ListCreationForm listCreationForm = new ListCreationForm();
    private ListCreated listCreated;

    @When("I create the list with name {string}")
    public void iCreateTheListWithName(String listTitle) {
        listCreated = listCreationForm.createList(listTitle);
    }

    @Then("I should see the title {string} in list")
    public void iShouldSeeTheTitleInList(String expectedListTitle) {
        String actualListTitle = listCreated.getListName();
        Assert.assertEquals(expectedListTitle, actualListTitle);
    }
}
