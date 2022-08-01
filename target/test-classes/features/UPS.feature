@ups
  Feature: UPS

    @ups1
    Scenario: E2E UPS Scenario
      Given I go to "ups" page
      And I go to Create a Shipment
      When I fill out origin shipment fields "regular"
      And I submit the shipment form
      Then I verify origin shipment fields submitted "regular"
