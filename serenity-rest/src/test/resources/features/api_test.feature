
Feature: Testing an API reqres.in with Serenity Screenplay Rest.

  @GETMethod
  Scenario: GET Method Test
    Given that the user wants to make a request
    When he makes the request, using the GET method
    Then the service return the data

  @POSTMethod1
  Scenario: Register a new user
    Given that the user wants to make a request
    When he wants to register a new user, using the POST method1
    Then the user is registered correctly

  @POSTMethod2
  Scenario: POST Method Test
    Given that the user wants to make a request
    When he makes the request, using the POST method2
    Then a valid response is returned