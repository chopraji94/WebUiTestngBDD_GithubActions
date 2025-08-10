Feature: Test login functionality to demo project using properties file

  Scenario: Test login Functionliaty
    Given I open Login url
    When I enter valid user credentials
    And I enter valid user password
    And I click Submit button
    Then I verify "Logged In Successfully" is displayed after succesfull login