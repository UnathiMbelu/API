Feature: Select all bulldogs 
  Scenario: Should display list of all bull dogs
  	Given Dogs
    When user fetch all bull dogs
	Then "message" in response "bulldog"
