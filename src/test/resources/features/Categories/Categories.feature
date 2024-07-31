Feature: Manage Categories

  Background:
    Given user logged in the CMS system with "Admin" role

  Scenario: Add new Category
    Given User has access to the Category page
    When User has finished entering the category information
      | CategoryName | Address |
      | Computer     | Ha Noi  |
    And click the Save button
    Then The message "Category has been created successfully" successfully displays


# Scenario Outline: Add new Category
#    Given User has access to the Category page
#    When User has finished entering the category information "<CategoryName>"
#      | CategoryName | Address |
#      | Computer     | Ha Noi  |
#    And click the Save button
#    Then The message "Category has been created successfully" successfully displays
#   Examples:
#     | CategoryName | Address |
#     | Computer     | Ha Noi  |