@java
  Feature: Java feature

    @java1
    Scenario: Hello World
      When I hello world
      And I say "Hello"
      And I say "Hi"

    Scenario: Methods Exercises Name
        Given I perform actions with "Name"


    Scenario: Methods Exercises var and VAR
      Given I perform actions with "my var" and "my VAR"

    Scenario: I write Java
     Given I write java

    Scenario: I divide exercise
      Given I divide one by second




    Scenario: "I print url for string page"
      Given I print url for "google" page
      Given I print url for "quote" page
      Given I print url for "yahoo" page

    Scenario: Compare two strings
      Given I compare "string1" and "string1"


    Scenario: Days of the week
      Given I print "7" th day of week

    Scenario: Steps with conditions
      Given I print if number "-1" is positive

    Scenario: Color
      Given Favorite color "blue" and Not favorite color "red"

    Scenario: Arrays week days
      Given I print "7" day of the week from array
