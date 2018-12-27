@asset
Feature:  Manage Asset

Scenario: Adding and Managing the asset
				Given the application URL
				When the user enters username and password
				And clicks Login Button
				And  clicks LMS option
				And clicks Menu option
				And clicks Content Management
				And clicks Manage Asset Library
				And clicks Asset Link
				And clicks Add Folder
				And types in the folder name
				And clicks Save button
				And clicks Add Asset Button
				And types Asset Name
				And clicks PDF option
				And clicks BROWSE button
				And clicks SAVE button
				Then PDF asset gets created
