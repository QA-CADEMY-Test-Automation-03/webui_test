package webui.test.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import webui.test.pages.Board;
import webui.test.pages.BoardCreationForm;
import webui.test.pages.CreateMenu;
import webui.test.pages.Header;

import java.util.List;
import java.util.Map;

public class BoardsSteps {
    private Header header = new Header();
    private CreateMenu createMenu;
    private BoardCreationForm boardCreationForm;
    private Board board;


    @Given("I open board creation form")
    public void iOpenBoardCreationForm() {
        createMenu = header.openCreateMenu();
        boardCreationForm = createMenu.openCreateBoardForm();
    }

    @And("I create the board with name {string}")
    public void iCreateTheBoardWithName(String boardTitle) {
        board = boardCreationForm.createBoard(boardTitle);
    }

    @Then("I should see the title {string} in board")
    public void iShouldSeeTheTitleInBoard(String expectedBoardTitle) {
        String actualBoardTitle = board.getBoardTitle();
        Assert.assertEquals(expectedBoardTitle, actualBoardTitle);
    }

    //DataTable using list of lists
//    @When("I create a board with following data")
//    public void iCreateABoardWithFollowingData(List<List<String>> boardData) {
//        String boardTitle = boardData.get(0).get(1);
//        String boardTheme = boardData.get(1).get(1);
//
//        board = boardCreationForm.createBoard(boardTitle, boardTheme);
//    }

    //DataTable using list of Maps
//    @When("I create a board with following data")
//    public void iCreateABoardWithFollowingData(List<Map<String, String>> boardData) {
//        String boardTitle = boardData.get(0).get("Title");
//        String boardTheme = boardData.get(0).get("Theme");
//
//        board = boardCreationForm.createBoard(boardTitle, boardTheme);
//    }

    //DataTable using DataTable object
    @When("I create a board with following data")
    public void iCreateABoardWithFollowingData(DataTable boardData) {
        Map<String, String> boardFields = boardData.asMap(String.class, String.class);
        String boardTitle = boardFields.get("Title");
        String boardTheme = boardFields.get("Theme");

        board = boardCreationForm.createBoard(boardTitle, boardTheme);
    }
}
