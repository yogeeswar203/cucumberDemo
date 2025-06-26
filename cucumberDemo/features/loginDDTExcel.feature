Feature: Login Data Driven with Excel
	
	Scenario Outline: Login Data Driven Excel
		Given the user navigate to home page
		And click on login button
		Then the user enters the username and password by using the excelrow "<row_index>"
		
		Examples: 
			| row_index 	|
			| 					1 |
			| 					2 |
			| 					3 |
			