@login
Feature: Login
  @smoke @positive
  Scenario: Login with valid credentials
    Given I am on login page
#    When I login with username "joseccb1948@outlook.com" and password "Control*1234"
    When I login with username "jose"
    Then I should see "joseccb1948@outlook.com" in profile menu

  @negative
  Scenario: Login with wrong password
    Given I am on login page
    When I login with username "joseccb1948@outlook.com" and password "abc"
    Then I should see the error message "Incorrect email address and / or password."
    And I should see a link contains "/login/resetpassword?application=trello&continue"
 @outline
  Scenario Outline: Login with wrong credentials
    Given I am on login page
    When I login in single page with username "<username>" and password "<password>"
    Then I should see the error message in single page "<messageError>"

    Examples:
      | username | password | messageError                             |
      | ruben    | 123      | This account doesn't have a password set |
      |          | 123      | Missing email123                            |
