Feature: Todos Management website test

  Scenario: Add todo task
    Given User navigation to the todo management website
    When Enter name on todo field
    And User should be click on enter button
    And Verify generated todo name
    And Verify Count of todo

    #
  #Scenario: Add multiple todos
    #
    #When User should be create multiple todos 
    #When Verify Counts of todos