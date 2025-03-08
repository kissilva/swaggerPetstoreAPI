@pet
Feature: Pet API Testing

  @createPetSuccessfully
  Scenario: Create a new pet successfully
    Given "Andres" is able to use the API
    When the user creates a new pet with valid data
    Then the pet should be created successfully

  @updatePetSuccessfully
  Scenario: Update an existing pet successfully
    Given "Andres" is able to use the API
    When the user updates an existing pet
    Then the pet should be updated successfully


  @searchAPetSuccessfully
  Scenario: Search for an existing pet successfully
    Given "Andres" is able to use the API
    When the user searches for a pet with id 326
    Then the pet should be found successfully

  @notFoundAPet
  Scenario: Search for a non-existent pet
    Given "Andres" is able to use the API
    When the user searches for a pet with id 100
    Then the pet search should fail

  @deletePetSuccessfully
  Scenario: Delete a pet successfully
    Given "Andres" is able to use the API
    When the user deletes the pet with id 326
    Then the pet should be deleted successfully