Feature: Cards
  Background: Create list
    Given I am on login page
    And I login with username "joseccb1948@outlook.com" and password "Control*1234"
    And I open board creation form
    And I create the board with name "My board"

  Scenario: Create more than one card in the same list
    Given I create the list with name "My List"
    When I create the following cards
      | Title     |
      | my card1  |
      | my card2  |
    Then I see the following cards
      | Title     |
      | my card1  |
      | my card2  |

  @actions
  Scenario: Move card to different list
    Given I create the list with name "In Progress"
    And I create the list with name "Done"

    And I create a card named "Smoke Test" in the list "In Progress"
    When I move the card "Smoke Test" to list "Done"
    Then I should see the card "Smoke Test" into the list "Done"

  @attach
  Scenario: Attach file to card
    Given I create the list with name "In Progress"
    And I create a card named "Implement searching" in the list "In Progress"
    And I open the card "Implement searching"
    When I attach a file
    Then I should see the file name in attachments section


