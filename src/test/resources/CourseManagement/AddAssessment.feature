@assessment
Feature: Manage Assessment functionality

Scenario: Adding Assessment
				Given the application URL
				When the user enters username and password
				And clicks Login Button
				And  clicks LMS option
				And clicks Menu option
				And clicks Content Management
				And clicks Manage Assessments menu
				And clicks Add New Assessment Button
				And types in the assessment name
				And fills up the infomation
				And clicks Questions menu
				And selects the questions and clicks AddQuestions 
				And clicks DesignSave and Cancel Button
				And mentions the email address and click Send For Approval
				And clicks Approve link