@account_activity_navigation

Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given user is on the home page
    And user clicks on signin button to access login page
    And user enters valid username and password on loginpage
    And user navigates to "Account Summary" page


  Scenario: Savings account redirect

    When the user clicks on "Savings" link on the Account Summary page
    And user should verify that "Zero - Account Activity" is displayed as title
    Then Account drop down should have "Savings" selected


  Scenario: Brokerage account redirect

    When the user clicks on "Brokerage" link on the Account Summary page
    And user should verify that "Zero - Account Activity" is displayed as title
    Then Account drop down should have "Brokerage" selected


  Scenario: Checking account redirect

    When the user clicks on "Checking" link on the Account Summary page
    And user should verify that "Zero - Account Activity" is displayed as title
    Then Account drop down should have "Checking" selected


  Scenario: Credit Card account redirect

    When the user clicks on "Credit Card" link on the Account Summary page
    And user should verify that "Zero - Account Activity" is displayed as title
    Then Account drop down should have "Credit Card" selected


  Scenario: Loan account redirect

    When the user clicks on "Loan" link on the Account Summary page
    And user should verify that "Zero - Account Activity" is displayed as title
    Then Account drop down should have "Loan" selected