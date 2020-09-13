Feature: Get available pets and confirm the name and category

Scenario: Retrieve all available pets and confirm that the name “doggie” with category id "12" is on the list
	Given Fetch pets available
	When user calls findPets "available" with GET HTTP request method
	Then "name" should be "doggie" and category "id" must be "12" in response body
	And the call processes successful with status code 200