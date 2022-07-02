Feature: Examples of scenarios and methods of how to work with APIs in ScreenPlay will be shown.

  @ScenarioCreate
  Scenario: Example case to create.
    When the user to create with some parameter ??? and the data
      | name    | last_name | phone |
      | example | example   | 123   |
    Then should see status code ???
    And should see a response ???

  @ScenarioUpdate
  Scenario: Example case to update.
    When the user to update with some parameter ??? and the data
      | name    | last_name | phone |
      | example | example   | 123   |
    Then should see status code ???
    And should see a response ???

  @ScenarioFind
  Scenario: Example case to find.
    When the user to find with the data
      | name    | last_name | phone |
      | example | example   | 123   |
    Then should see status code ???
    And should see a response ???

  @ScenarioDelete
  Scenario: Example case to delete.
    When the user to delete the user ???
      | name    | last_name | phone |
      | example | example   | 123   |
    Then should see status code ???
    And should see a response ???

  @ScenariosOutline
  Scenario Outline: Example case scenarios outline.
    When The user tests the scenario outline with the data
      | name   | last_name   | phone   |
      | <name> | <last_name> | <phone> |
    Then should see status code ???
    And should see a response ???
    Examples:
      | name     | last_name | phone |
      | example1 | example1  | 123   |
      | example2 | example2  | 123   |
      | example3 | example3  | 123   |