Feature: Lists
  Background: Create board
    Given I am on login page
    And I login with username "joseccb1948@outlook.com" and password "Control*1234"
    And I open board creation form
    And I create the board with name "My board"

  Scenario: Create a list
    When I create the list with name "My list"
    Then I should see the title "My list" in list
