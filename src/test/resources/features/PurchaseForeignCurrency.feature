@Available_currencies
Feature: Purchase Foreign Currency

  Background:
    Given user is on the home page
    And user clicks on signin button to access login page
    And user enters valid username and password on loginpage
    And user navigates to "Pay Bills" page



  Scenario: Available currencies
    And user clicks on the "Purchase Foreign Currency" tab
    Then following currencies should be available under Currency dropdown

      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |


  Scenario: Error message for not selecting currency
    And user clicks on the "Purchase Foreign Currency" tab
    When user tries to calculate cost without selecting a currency
    Then error message "Please, ensure that you have filled all the required fields with valid values." should be displayed

  @12
  Scenario: Error message for not entering value
    And user clicks on the "Purchase Foreign Currency" tab
    When user tries to calculate cost without entering a value
    Then error message "Please, ensure that you have filled all the required fields with valid values." should be displayed

