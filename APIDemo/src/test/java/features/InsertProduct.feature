Feature: Insert Product using POST API

  Scenario Outline: validate post product api status code works correctly
    Given I hit the url of post product api endpoint
    When I pass the url of product in the request
    And I pass the request body of product title<ProductTitle>
    Then I receive responce code as 201
    Examples:
      | ProductTitle  |
      | Shoes         |

  Scenario Outline: validate post product api responce body works correctly
    Given I hit the url of post product api endpoint
    When I pass the url of product in the request
    And I pass the request body of product title<ProductTitle>
    Then I receive responce body with id as<id>
    Examples:
      | ProductTitle  | id |
      | Shoes         | 21 |