Feature: Verify the Signup Functionality

  Scenario: Verify user Create a account with valid data
    Given user is on signup screen
    When user enter the valid firstname lastname DOB email mobilenumber password and click on check box
    Then user click on signup button
