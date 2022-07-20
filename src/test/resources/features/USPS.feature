@zip
  Feature: Zip code

    @zip1
    Scenario: Validate ZIP code for Portnov Computer School
      Given I go to "usps" page
      When I go to Lookup ZIP page by address
      And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
      Then I validate "94022" zip code exists in the result


    Scenario: Calculate price
      Given I go to "usps" page
      When I go to Calculate Price Page
      And I select "Canada" with "Postcard" shape
      And I define "2" quantity
      Then I calculate the price and validate cost is "$2.80"

      @usps1
      Scenario Outline: Validate ZIP code for addresses
        Given I go to "usps" page
        When I go to Lookup ZIP page by address
        And I fill out "<street>" street, "<city>" city, "<state>" state
        Then I validate "<zip>" zip code exists in the result
        Examples:
          |   street                 | city       | state  | zip   |
          |  4970 El Camino Real     | Los Altos  | CA     | 94022 |
          |  20  Broad st            | New York   | NY     | 10005 |
          |  440 S.LaSalle st        | Chicago    | IL     | 60605 |