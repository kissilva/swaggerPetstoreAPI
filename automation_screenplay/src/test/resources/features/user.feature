@user
Feature: User API Testing

  @searchAUserSuccessfully
  Scenario: Search a user successfully
    Given "Andres" is able to use the API
    When the user searches for a user with username "theUser"
    Then the user should be found successfully

  @notFoundAUser
  Scenario: Search for a non-existent user
    Given "Andres" is able to use the API
    When the user searches for a user with username "fakeUser"
    Then the user search should fail

  @createUserSuccessfully
  Scenario: Create a user successfully
    Given "Andres" is able to use the API
    When the logged user creates a new user with valid data
    Then the user should be created successfully

  @loginUserSuccessfully
  Scenario: Log in with valid credentials
    Given "Andres" is able to use the API
    When the user log in with valid credentials
    Then he should be logged in successfully