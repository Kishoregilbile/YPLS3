@course
Feature: Manage Course

@login
Scenario: Login
			Given the application url
			When I enter username and password
			And clicks Login button
			Then I should be logged In
			And I should select proper LMS option
			
Scenario: Upload Course
			Given the user is logged in
			And the user clicks on the Manage Course option
			And clicks on the Add New Course
			When Fills the Course Details and Saves it
			Then the course is added and is displayed on the Course List Page
			
Scenario: Verifying the Uploaded Course
			Given The course is displayed on the page
			And I launch the course
			Then it launches properly 