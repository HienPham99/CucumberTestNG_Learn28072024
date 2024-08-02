Feature: Manage Category

  Background:
    Given user logged in the CMS system with "Admin" role

  Scenario: Add new Category
    Given User has access to the Category page
    When User has finished entering the category information
    And click the Save button
    Then The message "Category has been created successfully" displays


Scenario: update the category existing
  Given User has access to the Category page
  When user search a category existing "Anh tester"
  And user edit the category information
  And click the Save button
  Then The message "Category has been updated successfully" displays