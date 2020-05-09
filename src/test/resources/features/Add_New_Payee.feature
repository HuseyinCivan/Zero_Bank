@add_new_payee
Feature: Add new payee under pay bills

  Background:
    Given user is on the home page
    Given user is on the home page
    And user clicks on signin button to access login page
    And user enters valid username and password on loginpage
    And user navigates to "Pay Bills" page

  Scenario: Add a new payee
    And user clicks on the "Add New Payee" tab
    And creates new payee using following information payee Name
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |

    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed

