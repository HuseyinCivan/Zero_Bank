@Account_Activity
Feature: Account Activity

  Background:
    Given user is on the home page
    And user clicks on signin button to access login page
    And user enters valid username and password on loginpage
    And user navigates to "Account Activity" page

  Scenario: Account Activity page title

    Then user should verify that "Zero - Account Activity" is displayed as title


  Scenario: Default account
    Then user should verify that "Savings" is default account

  Scenario: Account types
    Then user should verify that Account drop down should have the following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario:Transaction table
    Then transaction table have following column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |



