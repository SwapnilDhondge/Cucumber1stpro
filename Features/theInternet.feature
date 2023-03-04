#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: testing practice1
  I want to use this template for my feature file
 Background: List of steps run before each of the scenarios
 Given  user launch browser and goto url  
    
  @linkcheck
  Scenario: verify A/B Testing link
   
    Then verify the title of Webpage
    When User click on A/B testing link
    Then user redirect to new page and verify title of page 
    
    @Element
  Scenario: verify ADD and REmove element

    When User click on add or remove element link
    Then User click on Add Element button
    And User Again click on add element button
    And User Again click on Delete  button

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
