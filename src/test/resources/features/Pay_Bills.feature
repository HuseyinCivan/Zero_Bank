@pay_bills
Feature: Pay Bills

  Background:
    Given user is on the home page
    Given user is on the home page
    And user clicks on signin button to access login page
    And user enters valid username and password on loginpage
    And user navigates to "Pay Bills" page


  Scenario:Pay Bills page title
    Then user should verify that "Zero - Pay Bills" is displayed as title

  Scenario: successful pay operation
    And user select a random payee
    And user select a random account
    And user enters "90.99" as amount
    And user select today's date
    And user enter "make payment" to description
    And user click the pay button
    Then user should verify "The payment was successfully submitted." message is displayed


  Scenario: amount field
    And user enters "abc$" as amount
    And user select today's date
    And user click the pay button
    Then user should verify "Amount field does not accept alphabetical or special characters." message is displayed


  Scenario: date field
    And user enters "90.99" as amount
    And user select "abcd" as date
    Then user should verify date field is empty







