package webui.test.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import webui.test.core.Environment;
import webui.test.pages.*;

public class LoginSteps {
    private Welcome welcome =  new Welcome();
    private Login login;
    private Header header;
    private Profile profile;
    private LoginError loginError =  new LoginError();

    @Given("I am on login page")
    public void iAmOnLoginPage() {
        login = welcome.openLogin();
    }

    @When("I login with username {string}")
    public void iLoginWithUsername(String userName) {
        String user = Environment.getInstance().getValue(String.format("$['users']['%s']['user']", userName));
        String password = Environment.getInstance().getValue(String.format("$['users']['%s']['password']", userName));
        this.header = this.login.login(user, password);
    }
    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String userName, String password) {
        header = login.login(userName, password);
    }

    @Then("I should see {string} in profile menu")
    public void iShouldSeeInProfileMenu(String expectedAccountEmail) {
        profile = header.openProfileMenu();
        String actualAccountEmail = profile.getAccountEmail();

        Assert.assertEquals(expectedAccountEmail, actualAccountEmail);
    }

    @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String expecetedErrorMessage) {
        String actualErrorMessage = loginError.getErrorMessage();
        Assert.assertTrue(actualErrorMessage.contains(expecetedErrorMessage));
    }

    @And("I should see a link contains {string}")
    public void iShouldSeeALinkContains(String expectedResetLink) {
        String actualResetLink = loginError.getResetLink();
        Assert.assertTrue(actualResetLink.contains(expectedResetLink));
    }

    @When("I login in single page with username {string} and password {string}")
    public void iLoginInSinglePageWithUsernameAndPassword(String username, String password) {
        login.loginInSingleStep(username, password);
    }

    @Then("I should see the error message in single page {string}")
    public void iShouldSeeTheErrorMessageInSinglePage(String expectedErrorMessage) {
        String actualErrorMessage = login.getErrorMessage();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }
}
