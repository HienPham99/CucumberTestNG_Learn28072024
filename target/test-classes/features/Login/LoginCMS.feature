Feature: Login CMS

  @success
  Scenario: Login success
    Given User navigate to login page "https://cms.anhtester.com/admin"
    When User enter email "admin@example.com" and password "123456"
    And click login button
    Then User redirect to admin page "https://cms.anhtester.com/admin"
    And User should see the notification displays

#  @success
#  Scenario: Sucessful login with valid credentials
#    Given user has access on the login page
#    When I enter my valid username and password
#    And  I click the login button
#    When user log in to the CRM system with Project Manager role
#    Then I should be redirected to my account dashboard
#    And I should see a welcome message with my username
#    Then the user shall logger in successfully(verify header page, verify message, verify url, verify customer page)
#
#
#  @invalid
#  Scenario Outline: Failed login with invalid credentials
#    Given I am on the login page
#    When I enter my invalid username and password
#    And  I click the login button
#    Then I should see an error message
#    And I should still be on the login page
#    Examples:
#      | EMAIL             | PASSWORD | PIN |
#      | abc@email.com     | 123456   | 123 |
#      | admin@example.com | 678      | 123 |
#
#
#  @invalid
#  Scenario: Failed login with email invalid
#    Given user has access to the login page
#    When I enter my invalid username and password
#    And  I click the login button
#    Then I should see an error message
#    And I should still be on the login page
#
#  @invalid
#  Scenario: Failed login with password invalid
#    Given I am on the login page
#    When I enter my invalid username and password
#    And  I click the login button
#    Then I should see an error message
#    And I should still be on the login page