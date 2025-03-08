@store
Feature: Store API Testing

  @placeAOrderSuccessfully
  Scenario: Place a new order in the store successfully
    Given "Andres" is able to use the API
    When the user places a new order with valid data
    Then the order should be placed successfully

  @searchAOrderSuccessfully
  Scenario: Search for an existing order successfully
    Given "Andres" is able to use the API
    When the user searches for a order with id 326
    Then the order should be found successfully

  @deleteOrderSuccessfully
  Scenario: Delete a order successfully
    Given "Andres" is able to use the API
    When the user deletes the order with id 326
    Then the order should be deleted successfully