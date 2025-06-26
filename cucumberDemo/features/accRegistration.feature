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
@tag
Feature: User is able to register on portal
  I want to use this template for my feature file

  @sanity
  Scenario: Registration of the user
    Given navigate to Home page
    And click on the Register button
   	When the user enters the below registartion fields
   		| firstName 		| Jhon						|
   		| lastName 			| Kendy						|
   		| eMail 				| test@gmail.com	|
   		| telephone 		| 1234569					|
   		| password 			| test@123				|
   		| cnf_pswd 			| test@123				|
   And user select subscribe button
   And user accepted the policy button
   	

