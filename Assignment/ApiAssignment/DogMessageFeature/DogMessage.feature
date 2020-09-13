Feature: Select a random breed

  Scenario: Should display success message when I select a random breed
    Given Dogs
    When Select breed
    Then "status" Display message "success"
    And Show "Success"
