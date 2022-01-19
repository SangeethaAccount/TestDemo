Feature: Verify the Login Functionality

  Scenario: Verify user Login with valid credentials
    Given user is on login screen
    When user enter the valid email or mobile and Password
    Then user click on login button
