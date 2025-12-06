Feature: Get user by ID

  Scenario: Fetch user details
    Given the API base URL is set
    When I request user details for user id 2
    Then the response status should be 200
    And the user first name should be "Janet"