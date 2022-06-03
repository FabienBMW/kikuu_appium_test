#@REQ_OF-488 Nocibe
Feature: Found Products

	Background: Application initialization
		Given user launches the application
		And he lets the application to make call
		And he lets the application to access medias
		And he skip the authentication screen
		When user chooses his(her) country "Cameroon"
		And he authorizes the application to get position
		Then he should access home page

	@TEST_OF-649
	Scenario Outline: Find a product with search bar
		Given User is on search bar
		When User enter a "<product>" in search bar
		And User validate his choice
		Then User should see products that contain "<product>"

		Examples:
		  |product     |
		  |Phone      |


	@TEST_OF-648
	Scenario Outline: Suggestions when entering a product
		Given User is on search bar
		When User enter a "<text>" in search bar
		Then User should see suggestions appear for "<text>"

		Examples:
		  |text     |
		  |phone    |


	@TEST_OF-659
	Scenario Outline: Not find product
		Given User is on search bar
		When User enter a "<product>" in search bar
		And User validate his choice
		Then User should see message about no result found

		Examples:
		  |product     |
		  |Bbobda      |
#
#
#	@TEST_OF-652
#	Scenario Outline: Find a product with homepage category
#		Given User is on selected "<category>"
#		When User selected "<subcategory>"
#		Then User should see "<result_Page>" title display
#
#		Examples:
#			|category   |subcategory  |result_Page  |
#			|Parfum     |Parfum Homme |PARFUM HOMME |
#
#
	@TEST_OF-653
	Scenario Outline: Subcategory occurence from product category
		Given User is on category page
		When User is on selected "<category>"
	    Then User should see "<subcategory>"

		Examples:
			|category   |subcategory |
			|Beauté     |Maquillage  |
