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


Feature: Logging with Valid Credintials

	@sanity
	Scenario: Successful Login into QAFOX.com
		Given the user navigate to home page
		And click on login button
		When user enters email as "testautomation12123@gmail.com" and password as "test"
		And user clicks on Login button
		Then user navigated to MyAccount Page
		
	@smoke
	Scenario Outline: Log in Data Driven testing
		Given the user navigate to home page
		And click on login button
		When user enters email as "<email>" and password as "<password>"
		And user clicks on Login button
		Then user navigated to MyAccount Page
		
		Examples: 
			| email 												| password 		|
			| testan12123@gmail.com					| test				|
			| testautomation12123@gmail.com	| test				|
			