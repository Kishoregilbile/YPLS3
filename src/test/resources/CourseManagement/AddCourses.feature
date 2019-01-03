@course
Feature: Manage Course

@login
Scenario: Login and Upload the Course
			Given the application url
			And the username and password
			When the user clicks Login button
			And selects proper LMS option
			And clicks on the Manage Course option
			And clicks on the Add New Course
			And Fills the Course Details and Saves it
			Then the course is added and is displayed on the Course List Page
			And The course is displayed on the page
			When the user launchs the course
			Then it launches properly 