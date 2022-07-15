@quote
Feature: Quote project

  @quote1
  Scenario: Quote test
    Given I go to "quote" page
    And I print page details

  @quote2
  Scenario: Google and Quote
    Given I go to "google" page
    And I go to "quote" page
    And I go back and forward, then refresh the page


  Scenario: Resolution
    Given I go to "page" page
    And I change resolution to "res"



  Scenario: Fill out fields
    Given I go to "quote" page
    And I fill out required fields

