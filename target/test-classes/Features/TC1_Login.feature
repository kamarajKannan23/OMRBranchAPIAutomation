@Login
Feature: Login module API automation

  @LoginAndaddAddress
  Scenario: Get User logtoken from login endpoint
    Given User add header
    And User add basic authentication for the login
    When User send "POST" request for login endpoint
    Then User verify the status code is 200
    And User verify the login responce body firstName present as "Kamaraj" and get the logtoken saved
