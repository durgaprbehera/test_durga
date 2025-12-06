Feature: Book a round-trip flight on MakeMyTrip

  Scenario: Search for round-trip flights from Delhi to Mumbai
    Given I launch the MakeMyTrip application
    And I select "Round Trip" as the trip type
    And I enter "Delhi" as the source city
    And I enter "Mumbai" as the destination city
    And I select departure date as "2025-05-10"
    And I select return date as "2025-05-15"
    And I click on the Search button
    Then I should see a list of available flights
    And the flight results should include flights from "Delhi" to "Mumbai"