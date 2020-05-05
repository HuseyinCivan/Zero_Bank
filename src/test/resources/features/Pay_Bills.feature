Feature: Pay Bills
Background:
  Given user is on the home page
  Given user is on the home page
  And user clicks on signin button to access login page
  And user enters valid username and password on loginpage
  And user navigates to "Pay Bills" page


  Scenario:Pay Bills page title
    Then user should verify that "Zero - Pay Bills" is displayed as title



