Feature: Login to CRM
  As a user, I want to be able to login in to the CRM system
  So that I can manage customer infomation

  Example: Successful login
    Given I am on the login page
    When I enter my username and password
    And  I click the login button
    Then I should be taken to the Dashboard page
    And I should see the "Customers" menu
    And User should see the notification displays

#  Scenario Outline: eating
#    Given There are "<start>" cucumbers
#    When I eat "<eat>" cucumbers
#    Then I should have "<left>" cucumbers
#
#    Examples:
#      | start | eat | left |
#      | 12    | 5   | 7    |
#      | 20    | 5   | 15   |