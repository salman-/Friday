@all
Feature: 
  As a customer, I should be able to register for insurance.

  @all
  Scenario: The customer should be able to follow the steps to complete the registeration.
    Given I am in the starting page
    And I select "Das Auto ist schon versichert"
    And I want to have an insurance from today
    When I click on Weiter button
    Then It asks for the owner of the car
    
    And I am not the ownner of the car
    And the car is new when i purchase it
    When I click on Weiter
    Then It navigates to selectVehicle
