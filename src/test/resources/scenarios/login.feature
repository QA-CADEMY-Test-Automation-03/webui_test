Feature: Login

  Scenario: Login with valid credentials
    Given I am on login page
    When I login with username "joseccb1948@outlook.com" and password "Control*1234"
    Then I should see "joseccb1948@outlook.com" in profile menu

  Scenario: Login with wrong password
    Given I am on login page
    When I login with username "joseccb1948@outlook.com" and password "abc"
    Then I should see the error message "Incorrect email address and / or password."
    And I should see a link contains "/login/resetpassword?application=trello&continue"