Feature: Create a new insurance contract.
  As a customer, I should be able to register for insurance.

  Scenario Outline: The customer should be able to register for an insurance.
    Given I am in the starting page
    And The car is already insured
    And I want to have an insurance from today
    When I click on Weiter button
    Then It asks for the owner of the car
    And I am not the ownner of the car
    And the car is new when i purchase it
    When I click on Weiter
    Then It navigates to selectVehicle
    When I click on the "<brand>" of my car in the list
    Then I am asked to specify the model of my car in selectModel
    When I click on the "<model>" of my car
    Then I am asked to specify the body type of the car
    When I click on the "<body-type>" of the car
    Then I am asked to specify the Fuel Type of the car
    When I select the "<fuel>"
    Then I am asked to specify the horse power of the car
    When I select the "<engine-power>" of engine
    Then I am asked specify Engine
    When I select the "<engine>" of the car
    Then I am asked to specify the registeration date
    When I specify the registeration date
    Then I am asked to specify my birth date

    Examples: 
      | brand    | model    | body-type | fuel   | engine-power    | engine              |
      | TOYOTA   | Auris    | Kombi     | Benzin | 73 kW / 99 PS   | HSN: 5013, TSN: AIA |
      | TOYOTA   | Camry    | Kombi     | Diesel | 63 kW / 86 PS   | HSN: 7104, TSN: 494 |
      | BMW      | 3er      | Kombi     | Benzin | 95 kW / 129 PS  | HSN: 0005, TSN: 874 |
      | BMW      | 1er      | Cabrio    | Benzin | 105 kW / 143 PS | HSN: 0005, TSN: AMP |
      | BMW      | 2er      | Coupe     | Diesel | 110 kW / 150 PS | HSN: 0005, TSN: CCX |
      | CADILLAC | BLS      | Limousine | Benzin | 129 kW / 175 PS | HSN: 9116, TSN: AAM |
      | TOYOTA   | GT86     | Kombi     | Benzin | 73 kW / 99 PS   | HSN: 5013, TSN: AHS |
      | CADILLAC | ATS      | Limousine | Benzin | 129 kW / 175 PS | HSN: 9116, TSN: AAM |
      | CADILLAC | Eldorado | Limousine | Benzin | 224 kW / 305 PS | HSN: 1006, TSN: 971 |
