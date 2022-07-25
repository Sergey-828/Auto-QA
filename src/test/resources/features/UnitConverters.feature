@convert
Feature: Unit Converters

  @convert1
  Scenario Outline: Convert Temperature
    Given I go to <page> page
    When I would click to <conv> button
    And I would convert <num> <unitFrom> to <unitTo>
    Examples:
      | page         | conv          | num | unitFrom     | unitTo    |
      | "Converters" | "Temperature" | 54  | "Fahrenheit" | "Celsius" |


  Scenario: Convert Weight
    Given I go to "Converters" page
    When I would click to "Weight" button
    And I would convert 170 "Pound" to "Kilogram"


  Scenario: Convert Length
    Given I go to "Converters" page
    When I would click to "Length" button
    And I would convert 50 "Mile" to "Kilometer"
