@Address
Feature: Address Module API automation

  @LoginAndaddAddress @updateAddress @deleteAddress
  Scenario Outline: Verify add new address to the application through api
    Given User add headers and bearer authorization for accessing address endpoints
    When User add request body for add new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    And User send "POST" request for addUserAddress endpoint
    Then User verify the status code is 200
    And User verify the addUserAddress response message matches "Address added successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address       | address_type |
      | Kamaraj    | Kannan    | 6381763806 | Lake View |    35 | 3659 |     101 |  600097 | Thooraipakkam | Work         |

  @updateAddress
  Scenario Outline: Verify update address in the application through api
    Given User add headers and bearer authorization for accessing address endpoints
    When User add request body for update existing address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    And User send "PUT" request for updateUserAddress endpoint
    Then User verify the status code is 200
    And User verify the updateUserAddress response message matches "Address updated successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment          | state | city | country | zipcode | address      | address_type |
      | Kamaraj    | Kannan    | 7708613888 | Royal Empire Flats |    35 | 3659 |     101 |  600001 | Besant Nagar | Home         |

  @deleteAddress
  Scenario: Verify delete address in the application through api
    Given User add headers and bearer authorization for accessing address endpoints
    When User add request body for delete existing address
    And User send "DELETE" request for deleteUserAddress endpoint
    Then User verify the status code is 200
    And User verify the deleteUserAddress response message matches "Address deleted successfully"

  @getAddress
  Scenario: Verify get all addresses in the application through api
    Given User add headers and bearer authorization for accessing address endpoints
    When User send "GET" request for getUserAddresses endpoint
    Then User verify the status code is 200
    And User verify the getUserAddresses response message matches "OK"
