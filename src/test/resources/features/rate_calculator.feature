# src/test/resources/features/rate_calculator.feature
Feature: POS Malaysia Rate Calculator
  As a user
  I want to calculate shipping rates
  So that I can choose the best shipping option

  Scenario: Calculate shipment quote from Malaysia to India
    Given I navigate to the rate calculator page
    When I enter From postcode "35600"
    And I enter "India" as To country
    And I enter weight as "1" kg
    And I click Calculate button
    Then I should see multiple shipping quotes available