@ProfilePicture
Feature: ProfilePicture Module API automation

  Scenario: Verify upload profile picture to the application through API
    Given User add headers and bearer authorization for accessing upload profile picture endpoints
    When User add multipart for upload profile picture
    And User sent "POST" request for upload profile picture
    Then User verify the status code is 200
    And User verify the create upload profile picture response message matches "Profile updated Successfully"