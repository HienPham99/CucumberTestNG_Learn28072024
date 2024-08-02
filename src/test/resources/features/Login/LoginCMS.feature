Feature: Login CMS

  @success
  Scenario: Login success
    Given User navigate to login page "https://cms.anhtester.com/admin"
    When User enter email "admin@example.com" and password "123456"
    And click login button
    Then User redirect to admin page "https://cms.anhtester.com/admin"
    And User should see the notification displays

  @SuccessfulLogin
  Scenario: Successful login
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    Then the user should be redirected to the admin page

  @InvalidLogin
  Scenario: Invalid Login
    Given the user is on the login page
    When the user enters an invalid username or password
    And clicks the login button
    Then the user should see an error message
    And stay on the login page

  Scenario: Empty Username
    Given the user on the login page
    When the user leaves the username fields empty
    And clicks the login button
    Then the user should see an error message
    And stay on the login page

  Scenario: Empty Password
    Given the user on the login page
    When the user leaves the password fields empty
    And clicks the login button
    Then the user should see an error message
    And stay on the login page

  Scenario: Locked Account
    Given the user on the login page
    And my account has been locked
    When user enter valid username and password
    And clicks the login button
    Then the user should see an error message
    And stay on the login page


  Scenario: Forgotten Password
    Given the user on the login page
    And  the user have forgotten my password
    When user click on the "Forgot Password" link
    And enter my email address
    And click on the "Reset Password" button
    Then the user should receive an email with instructions to reset my password.