@boards
Feature: Boards
  Background: Login
    Given I am on login page
    When I login with username "joseccb1948@outlook.com" and password "Control*1234"

  @smoke
  Scenario: Create a board
    Given I open board creation form
    And I create the board with name "My board"
    Then I should see the title "My board" in board

  Scenario: Create a board with theme
    Given I open board creation form
    When I create a board with following data
      | Title | My board |
      | Theme | blue     |
#      | Title    | Theme |
#      | My board | blue  |
    Then I should see the title "My board" in board