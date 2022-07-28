@convert
Feature: Unit Converters

  @convert1
  Scenario Outline: Convert Temperature
    Given I go to "Converters" page
    When I would click to <conv> button
    And I would convert <num> <unitFrom> to <unitTo>
    Examples:
              | conv          | num  | unitFrom     | unitTo       |
              | "Temperature" | 54   | "Fahrenheit" | "Celsius"    |
              | "Weight"      | 170  | "Pound"      | "Kilogram"   |
              | "Length"      | 50   | "Mile"       | "Kilometer"  |


