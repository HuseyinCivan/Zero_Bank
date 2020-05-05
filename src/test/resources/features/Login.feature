Feature:Login
  Only authorized users should be able to login to the application


  Background:
    Given user is on the home page
    And user clicks on signin button to access login page

  @authorized_user
  Scenario: Login with valid credentials
    When user enters valid username and password on loginpage
    Then user should verify that "Zero - Account Summary" is displayed as title


  @invalid_credentials
  Scenario Outline: Login with invalid credentials
    When user enters invalid "<username>" and "<password>" on loginpage
    Then error message "Login and/or password are wrong." is displayed

    Examples:
      | username       | password       |
      | username       | wrong_password |
      | wrong_username | password       |
      | username       |                |
      |                | password       |
      |                |                |





