Feature: Login Phy Application

  Scenario: User Login into application successfully with valid username & password
    Given Enter valid Username & Password
    When Click on Login button
    Then Verify user should navigate to 'Productss' page