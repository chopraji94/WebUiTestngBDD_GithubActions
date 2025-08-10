Feature: Test login functionality to demo project

  Scenario: Test login Functionliaty
    Given I open Login url
    When I enter username student
    And I enter password Password123
    And I click Submit button
    Then I verify "Logged In Successfully" is displayed after succesfull login