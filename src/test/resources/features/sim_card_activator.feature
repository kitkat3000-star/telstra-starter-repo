Feature: Sim Card Activation
  Describes behaviour of the sim card activation process

  Scenario: A valid sim card is activated successfully
    Given a valid sim card
    When a request is sent to activate the sim card
    Then the sim card should be activated successfully and its status recorded in the database

  Scenario: An invalid sim card fails to activate
    Given an invalid sim card
    When a request is sent to activate the sim card
    Then the activation should fail and its status recorded in the database
