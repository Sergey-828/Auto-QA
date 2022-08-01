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

  @6
  Scenario: Quote page - alerts, iframe, new window
    Given I go to "quote" page
    And I "accept" third part agreement
    And I fill out contact name "Richard Roe" and phone "0123456789"
    Then I verify "Document 2" in related documents

  Scenario: e2e
    Given I go to "quote" page
    And I fill out required fields for "regular" user
#    And  I verify that fields values saved correctly for "regular"user
    And I wait for 3 sec




